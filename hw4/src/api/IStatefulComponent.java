package api;

/**
 * Subinterface of IComponent that adds methods for dealing with
 * components that have internal state.
 */
public interface IStatefulComponent extends IComponent
{
  /**
   * Updates the internal state, if any, provided that the component is enabled.
   */
  void tick();
  
  /**
   * Enables updates to the internal state, if any, when processing 
   * the tick() operation.
   */
  void setEnabled(boolean enabled);
  
  /**
   * Clears the internal state, if any (sets to all zeros).
   */
  void clear();
}
