package sample;

import api.Util;

public class TestSampleGate
{
  public static void main(String[] args)
  {
    SampleAndGate c = new SampleAndGate();
    Util.setInputs(c, "11");
    c.propagate();
    System.out.println(Util.toString(c.outputs())); // prints "1"
    Util.setInputs(c, "01");
    c.propagate();
    System.out.println(Util.toString(c.outputs())); // prints "0"
    c.invalidateOutputs();
    System.out.println(Util.toString(c.outputs())); // prints "-"
  }
}
