package ui;


import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import hw3.DotsGame;
import hw3.Generator;

/**
 * Main class for a GUI for a Dots game sets up a 
 * GamePanel instance in a frame.
 */
public class GameMain
{
  /**
   * Cell size in pixels.
   */
  public static final int SIZE = 40; 

  /**
   * Dot size in pixels, must be less than or equal to SIZE.
   */
  public static final int DOT_SIZE = 20; 

  /**
   * Font size for displaying score.
   */
  public static final int SCORE_FONT = 24; 

  /**
   * Background color.
   */
  public static final Color BACKGROUND_COLOR = Color.LIGHT_GRAY;
  
  /**
   * Colors for icon types (types outside range 0 - 7 will display as black).
   */
  public static final Color[] COLORS = {
      Color.RED,
      Color.GREEN,
      Color.CYAN,
      Color.YELLOW,
      Color.ORANGE,
      Color.BLUE,
      Color.MAGENTA,
      Color.PINK,   
  };
  
  /**
   * Helper method for instantiating the components.  This
   * method should be executed in the context of the Swing
   * event thread only.
   */
  private static void create()
  {
    String[] testgrid = {
      "0 0 1 2",
      "0 5 3 4",
      "1 5 5 3"
    };

    // EDIT HERE TO CHANGE THE GAME BEING CREATED
    
    // create a 7 x 8 game with 5 types of icons
    DotsGame game = new DotsGame(7, 8, new Generator(5, new Random()));
 
    // create a 3 x 4 game with a fixed initial grid and fixed generator (new
    // dots will always be pink)
    // DotsGame game = new DotsGame(testgrid, new Generator(7));

    
    // create the two UI panels
    ScorePanel scorePanel = new ScorePanel();
    GamePanel panel = new GamePanel(game, scorePanel);
    
    // arrange the two panels horizontally
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
    mainPanel.add(scorePanel);
    mainPanel.add(panel);
    
    // put main panel in a window
    JFrame frame = new JFrame("Com S 227 Dots Game");
    frame.getContentPane().add(mainPanel);

    // give panels a nonzero size
    Dimension d = new Dimension(game.getWidth() * GameMain.SIZE, game.getHeight() * GameMain.SIZE);   
    panel.setPreferredSize(d);
    d = new Dimension(game.getWidth() * GameMain.SIZE, 3 * GameMain.SIZE);   
    scorePanel.setPreferredSize(d);
    frame.pack();
    
    // we want to shut down the application if the 
    // "close" button is pressed on the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
    // rock and roll...
    frame.setVisible(true);
  }
  
  /**
   * Entry point.  Main thread passed control immediately
   * to the Swing event thread.
   * @param args not used
   */
  public static void main(String[] args)
  {
    Runnable r = new Runnable()
    {
      public void run()
      {
        create();
      }
    };
    SwingUtilities.invokeLater(r);
  }
}
