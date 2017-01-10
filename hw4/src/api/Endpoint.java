package api;

import java.util.ArrayList;

/**
 * An Endpoint represents a connection point in a digital 
 * circuit.  Each Endpoint has a value of 0 or 1, and may be
 * valid or invalid.  An Endpoint may be connected to 
 * zero or more other Endpoints, in which case setting its
 * value will also set the values of connected Endpoints.
 */
public class Endpoint
{
  /**
   * The value stored in this Endpoint.
   */
  private int value;
  
  /**
   * Represents whether or not this Endpoint is valid.
   */
  private boolean valid;
  
  /**
   * List of destination Endpoints to which this one is connected.
   */
  private ArrayList<Endpoint> connections;
  
  /**
   * List of listeners to be notified when this Endpoint changes.
   */
  private ArrayList<IListener> listeners; 
  
  /**
   * Component object to which this Endpoint belongs.
   */
  private IComponent parent;
  
  /**
   * Constructs an Endpoint with the given parent component.
   * Initially the state is invalid and the value is zero.
   * @param parent
   *   the component to which this endpoint belonds
   */
  public Endpoint(IComponent parent)
  {
    connections = new ArrayList<Endpoint>();
    listeners = new ArrayList<IListener>();
    this.parent = parent;
  }
  
  /**
   * Returns a reference to the component to which this
   * Endpoint belongs
   * @return
   *   reference to the parent component
   */
  public IComponent getParent()
  {
    return parent;
  }
  
  /**
   * Add a connection from this Endpoint to the given
   * destination.
   * @param destination
   *   the Endpoint that is to be connected to this one
   */
  public void connectTo(Endpoint destination)
  {
    connections.add(destination);
  }
  
  /**
   * Returns the list of Endpoints connected to this one.
   * @return
   *   list of Endpoints connected to this one
   */
  public ArrayList<Endpoint> getConnections()
  {
    return connections;
  }
  
  /**
   * Returns the value stored in this endpoint.
   * @return
   *   value stored in this endpoint
   */
  public int getValue()
  {
    return value;
  }
  
  /**
   * Sets this Endpoint to the invalid state.  Note that
   * this method does not modify connected Endpoints.
   */
  public void invalidate()
  {
    valid = false;
    notifyListeners();
  }
  
  /**
   * Returns whether this Endpoint is currently valid.
   * @return
   *   whether this Endpoint is valid
   */
  public boolean isValid()
  {
    return valid;
  }
  
  /**
   * Sets this Endpoint to have the given value (0 or 1) and changes the
   * state to valid.  All connected Endpoints are also set with
   * the same value.
   * @param givenValue
   *   value to be set
   */
  public void set(int givenValue)
  {
    value = givenValue;
    valid = true;
    
    for (Endpoint e : connections)
    {
      e.set(givenValue);
    }
    notifyListeners();
  }
  
  /**
   * Returns a String representation of this Endpoint's 
   * value as either "0" or "1", or "-" if the state is invalid.
   * @return
   *   a string representation of the value
   */
  public String toString()
  {
    if (valid)
    {
      return "" + value;
    }
    else
    {
      return "-";
    }
  }
  
  /**
   * Adds the given listener to this Endpoint's list
   * of listeners.
   * @param listener
   *   the listener to be added
   */
  public void addListener(IListener listener)
  {
    listeners.add(listener);
  }
  
  /**
   * Helper method notifies all listeners.
   */
  private void notifyListeners()
  {
    for (IListener listener : listeners)
    {
      listener.update(parent);
    }
  }
}
