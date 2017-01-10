package api;

/**
 * Utility class collecting some useful operations for instances of IComponent.
 */
public class Util
{
  /**
   * Sets the inputs of the given component from the given string of 
   * '0' and '1' characters, where the string is read right to left.
   * The rightmost character of the string corresponds to index 0 in the 
   * component's inputs.
   * If the string contains a character other than '0' or '1' in 
   * some position, the corresponding bit in the component's inputs
   * will not be set.
   * @param c
   *   the component whose inputs are to be set
   * @param values
   *   string of 0's and 1's 
   */
  public static void setInputs(IComponent c, String values)
  {
    setInputs(c, values, 0);
  }
  
  /**
  /**
   * Sets the inputs of the given component from the given string of 
   * '0' and '1' characters, where the string is read right to left.
   * The rightmost character of the string corresponds to the given
   * index 'start' of the component's inputs.
   * If the string contains a character other than '0' or '1' in 
   * some position, the corresponding bit in the component's inputs
   * will not be set.
   * @param c
   *   the component whose inputs are to be set
   * @param values
   *   string of 0's and 1's 
   * @param start
   *   starting index in the component's inputs to be set
   */
  public static void setInputs(IComponent c, String values, int start)
  {
    Endpoint[] endpoints = c.inputs();

    int srcIndex = values.length() - 1;
    int dstIndex = start;
    while (srcIndex >= 0 && dstIndex < endpoints.length)
    {
      // ignore characters other than '0' or '1'
      char ch = values.charAt(srcIndex);
      if (ch == '0')
      {
        endpoints[dstIndex].set(0);
      }
      else if (ch == '1')
      {
        endpoints[dstIndex].set(1);
      }
      srcIndex -= 1;
      dstIndex += 1;
    }

  }
  
  /**
   * Connects all outputs of the source component to all inputs
   * of the destination component (or as many as possible without
   * going out of bounds).
   * @param src
   *   source component
   * @param dst
   *   destination component
   */
  public static void connect(IComponent src, IComponent dst)
  {
    connect(src, 0, dst, 0, src.outputs().length);
  }
  
  /**
   * Connects outputs of the source component, starting with the given
   * index 'startSrc', to inputs of the destination component starting with
   * the given index 'startDst'.  The number of connections is at most the given
   * value 'howMany', but may be less to prevent out of bounds errors.
   * @param src
   *   source component
   * @param startSrc
   *   starting index in source component's outputs
   * @param dst
   *   destination component
   * @param startDst
   *   starting index in destination component's inputs
   * @param howMany
   *   number of connections to make
   */
  public static void connect(IComponent src, int startSrc, IComponent dst, int startDst, int howMany)
  {
    int count = 0;
    int srcIndex = startSrc;
    int dstIndex = startDst;
    while (srcIndex < src.outputs().length && dstIndex < dst.inputs().length && count < howMany)
    {
      Endpoint s = src.outputs()[0];
      Endpoint d = dst.inputs()[0];
      src.outputs()[srcIndex].connectTo(dst.inputs()[dstIndex]);
      count += 1;
      srcIndex += 1;
      dstIndex += 1;
    }
  }
  
  /**
   * Returns a string of 0's and 1's representing the given array of Endpoints,
   * listed right to left. Index 0 in the array corresponds to the 
   * rightmost character of the string.  Endpoints in the invalid
   * state will be represented by the dash character '-'
   * @param endpoints
   *   array of Endpoints
   * @return
   *   string of 0's and 1's representing the Endpoint values, listed right to left
   */
  public static String toString(Endpoint[] endpoints)
  {
    String result = "";
    for (int i = endpoints.length - 1; i >= 0; i -= 1)
    {
      char ch = '-';
      if (endpoints[i].isValid())
      {
        if (endpoints[i].getValue() == 0)
        {
          ch = '0';
        }
        else if (endpoints[i].getValue() == 1)
        {
          ch = '1';
        }
      }
      result = result + ch;
    }
    return result;
  }
  
  /**
   * Adds the given listener to all outputs of the given component.
   * @param c
   *   component to which to add the listener
   * @param listener
   *   object implementing the IListener interface
   */
  public static void addListener(IComponent c, IListener listener)
  {
    for (Endpoint e : c.outputs())
    {
      e.addListener(listener);
    }
  }
  
  /**
   * Converts the given string of 0's and 1's to an int array
   * having the same length, reading right to left (the rightmost character 
   * of the string corresponds to index 0 of the array).  Any
   * character in the string other than '0' or '1' is converted
   * to a -1 in the array.
   * @param values
   *   string of 0's and 1's
   * @return
   *   int array of corresponding numbers
   */
  public static int[] stringToIntArray(String values)
  {
    int[] ret = new int[values.length()];
    int index = 0;
    for (int i = values.length() - 1; i >= 0; i -= 1)
    {
      char ch = values.charAt(i);
      if (ch == '0')
      {
        ret[index] = 0;
      }
      else if (ch == '1')
      {
        ret[index] = 1;
      }
      else
      {
        ret[index] = -1;
      }
      index += 1;
    }
    return ret;
  }
}
