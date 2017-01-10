package api;

/**
 * Class that represents a grid position with a Dot.
 * Optionally, it is possible to record a "previous"
 * row for the icon, a feature that can be used to support animation of Dots
 * in a GUI.
 */
public class Descriptor
{
  /**
   * Row for this cell.
   */
  private final int row;
  
  /**
   * Column for this cell.
   */
  private final int col;
  
  /**
   * Dot in this cell.
   */
  private final Dot dot;
  
  /**
   * Previous row for this cell, if applicable.
   */
  private int previousRow;

  /**
   * Constructs a Descriptor with the given row, column, and Dot.
   * The previous row is the same as the given row.
   * 
   * @param row
   *   row for this cell
   * @param col
   *   column for this cell
   * @param dot
   *   the Dot in this cell
   */
  public Descriptor(int row, int col, Dot dot)
  {
    this.row = row;
    this.col = col;
    this.dot = dot;
    this.previousRow = row;
  }
  
  /**
   * Sets the previous row for this cell.
   * @param row
   *   previous row for this cell
   */
  public void setPreviousRow(int row)
  {
    previousRow = row;
  }

  /**
   * Returns the previous row for this cell.
   * @return
   *   previous row for this cell
   */
  public int getPreviousRow()
  {
    return previousRow;
  }
  
  /**
   * Returns the Dot in this cell.
   * @return
   *   the Dot in this cell
   */
  public Dot getDot()
  {
    return dot;
  }  

  /**
   * Returns the row of this cell
   * @return
   *   row of this cell
   */
  public int row()
  {
    return row;
  }
  
  /**
   * Returns the column of this cell
   * @return
   *   column of this cell
   */
  public int col()
  {
    return col;
  }
  
  /**
   * Determines whether this cell has the same position
   * as a given cell.
   * @param other
   *   the cell to compare with this one
   * @return
   *   true if the given cell has the same row and column
   *   as this one
   */
  public boolean samePosition(Descriptor other)
  {
    return row == other.row && col == other.col;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj == null || obj.getClass() != this.getClass())
    {
      return false;
    }
    Descriptor other = (Descriptor) obj;
    return row == other.row && col == other.col && dot.equals(other.dot);
  }
  
  /**
   * Returns a String representation of this Cell in the form:
   * <pre>
   * [(row, column) icon]
   * </pre>
   * if row is the same as the previous row, or
   * <pre>
   * [(row, column) icon (previous row)]
   * </pre>
   * otherwise.
   */
  @Override
  public String toString()
  {
    if (row == previousRow)
    {
      return String.format("[(%d,%d) %d]", row, col, dot.getType());
    }
    else
    {
      return String.format("[(%d,%d) %d (%d)]", row, col, dot.getType(), previousRow);
    }
  }
}
