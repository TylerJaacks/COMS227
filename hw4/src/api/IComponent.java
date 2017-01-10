package api;

/**
 * Interface representing a component in a simulation of digital circuits.
 */
public interface IComponent
{
  /**
   * Returns the array of Endpoints representing this component's inputs.
   * @return
   *   array of input Endpoints
   */
  Endpoint[] inputs();
  
  /**
   * Returns the array of Endpoints representing this component's outputs.
   * @return
   *   array of output Endpoints
   */
  Endpoint[] outputs();
  
  /**
   * Returns whether all inputs are valid.
   * @return
   *   true if all inputs are valid, false otherwise
   */
  boolean inputsValid();
  
  /**
   * Returns whether all outputs are valid.
   * @return
   *   true if all outputs are valid, false otherwise
   */  
  boolean outputsValid();
  
  /**
   * Changes the state of all inputs to invalid.
   */
  void invalidateInputs();
  
  /**
   * Changes the state of all outputs to invalid.
   */
  void invalidateOutputs();

  /**
   * Propagates inputs to outputs.  Does nothing if not all inputs are valid.
   */
  void propagate();
}
