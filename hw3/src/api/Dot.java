package api;

/**
 * A Dot is an abstraction of a color or other icon in the grid for a game.
 * Each Dot has a integer type, which can be thought of as a code for a
 * color or icon.
 */
public class Dot
{
  /**
   * Type of this Dot, normally interpreted as a color.
   */
  private final int type;
  
  /**
   * Constructs a Dot of the given type.
   * @param type
   *   type for this Dot
   */
  public Dot(int type)
  {
    this.type = type;
  }
  
  /**
   * Returns the type of this Dot.
   * @return
   *   type of this dot
   */
  public int getType()
  {
    return type;
  }
  
  /**
   * Determines whether this Dot has the same type as the given object.
   * @return
   *   true if the given object is a Dot and has the same type as this one,
   *   false otherwise
   */
  public boolean equals(Object obj)
  {
    if (obj == null || obj.getClass() != this.getClass()) return false;
    Dot other = (Dot) obj;
    return type == other.type;
  }

  /**
   * Returns the type of this Dot as a string.
   */
  public String toString()
  {
    return "" + type;
  }
}

