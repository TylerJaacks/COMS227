package sample;

import api.ExternalValue;
import api.Probe;
import api.Util;

public class TestSampleGateWithProbe
{
  public static void main(String[] args)
  {
    SampleAndGate c = new SampleAndGate();
    ExternalValue ex = new ExternalValue(2);
    Util.connect(ex, c);
    Util.addListener(c, new Probe("Test SampleAndGate"));
    ex.setValues("11");
    ex.propagate();
    c.propagate();
    ex.setValues("01");
    ex.propagate();
    c.propagate();    
    c.invalidateOutputs();
  }
}
