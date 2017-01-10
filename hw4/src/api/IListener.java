package api;

/**
 * Callback interface for notifying applications when the 
 * outputs of a component change.
 */
public interface IListener
{
  /**
   * Invoked by an Endpoint when its value changes.  The argument 
   * is the component to which the Endpoint belongs.
   * @param c
   *   parent component for the Endpoint invoking this method
   */
  public void update(IComponent c);
}
