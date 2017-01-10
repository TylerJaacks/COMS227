package api;

import java.util.Scanner;

import hw3.DotsGame;

/**
 * Utility class with some methods for initializing a grid of Dot objects
 * from data in a string, and for displaying the grid in an instance of
 * DotsGame.
 */
public class Util
{
  /**
   * Creates a 2D array of Dot objects from a String array.  Each string
   * in the array consists of the same number of whitespace-separated
   * tokens.  Each token is either an integer or the symbol "*".  The i-th
   * string is used to initialize the i-th row of the returned grid,
   * where an integer value becomes the corresponding Dot's type and a "*" symbol
   * indicates a null cell.
   * 
   * @param data
   *   String array describing initial values for the grid
   * @return
   *   2D array of Dot as initialized from the String array.
   */
  public static Dot[][] createGridFromString(String[] data)
  {
    // determine width by parsing first string
    int height = data.length;
    Scanner in = new Scanner(data[0]);
    int width = 0;
    while(in.hasNext()) 
    {
      in.next();
      width += 1;
    }
    
    // Create and initialize the grid based on string data
    Dot[][] grid = new Dot[height][width];
    for (int row = 0; row < height; row += 1)
    {
      int col = 0;
      in = new Scanner(data[row]);
      while(in.hasNext())
      {
        if (in.hasNextInt())
        {
          Dot d = new Dot(in.nextInt());
          grid[row][col] = d;
        }
        else
        {
          in.next(); // grid position will default to null
        }
        col += 1;
      }
    }
    return grid;
  }
  
  /**
   * Prints a representation of the given game's grid of Dots.
   * Each Dot is displayed as an integer representing its type,
   * and null cells in the grid are displayed as the "*" character.
   * 
   * @param game
   *   the game whose grid is to be printed
   */
  public static void printGrid(DotsGame game)
  {
    for (int row = 0; row < game.getHeight(); ++row)
    {
      StringBuilder sb = new StringBuilder();
      for (int col = 0; col < game.getWidth(); ++col)
      {
        if (col > 0) sb.append(" ");
        Dot icon = game.getDot(row, col);
        String s = (icon == null ? "*" : icon.getType() + "");
        sb.append(s);       
      }
      System.out.println(sb.toString());
    }
  }
}
