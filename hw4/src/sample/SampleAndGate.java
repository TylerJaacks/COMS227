package sample;

import api.Endpoint;
import api.IComponent;

/**
 * Concrete implementation of the IComponent interface representing
 * an and-gate with two inputs and one output.
 */
public class SampleAndGate implements IComponent
{
  /**
   * Outputs for this component.
   */
  private Endpoint[] outputs;
  
  /**
   * Inputs for this component.
   */
  private Endpoint[] inputs;
  
  /**
   * Constructs an and-gate.
   */
  public SampleAndGate()
  {
    inputs = new Endpoint[2];
    inputs[0] = new Endpoint(this);
    inputs[1] = new Endpoint(this);
    outputs = new Endpoint[1];
    outputs[0] = new Endpoint(this);
  }
  
  @Override
  public void invalidateInputs()
  {
    for (Endpoint e : inputs) e.invalidate();
  }
  
  @Override
  public void invalidateOutputs()
  {
    for (Endpoint e : outputs) e.invalidate();
  }
  
  @Override
  public boolean inputsValid()
  {
    for (Endpoint e : inputs)
    {
      if (!e.isValid()) return false;
    }
    return true;
  }
  
  @Override
  public boolean outputsValid()
  {
    for (Endpoint e : outputs)
    {
      if (!e.isValid()) return false;
    }
    return true;
  }
  
  @Override
  public Endpoint[] inputs()
  {
    return inputs;
  }

  @Override
  public Endpoint[] outputs()
  {
    return outputs;
  }
  
  @Override
  public void propagate()
  {
    if (inputsValid())
    {
      int newValue = 0;
      if (inputs()[0].getValue() == 1 && inputs()[1].getValue() == 1)
      {
        newValue = 1;
      }
      outputs()[0].set(newValue);
    }
  }

}
