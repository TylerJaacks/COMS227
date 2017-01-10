package ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import api.Descriptor;
import api.Dot;
import hw3.DotsGame;

/**
 * User interface for the main grid of a Dots-like game.
 */
public class GamePanel extends JPanel
{ 
  /**
   * Number of pixels each icon falls per frame when animating.
   */
  private int fallPerFrame = 4;
  
  /**
   * Interval between frames when animating falling icons,
   * in milliseconds.
   */
  private int fallingSpeed = 10;

  /**
   * Number of times to flash when a pair is selected.
   */
  private int numberOfFlashes = 3;
  
  /**
   * Interval between flashes, in milliseconds.
   */
  private int flashingSpeed = 50;
  
  /**
   * Score panel associated with the game.
   */
  private ScorePanel scorePanel;

  /**
   * The javax.swing.Timer instance used to animate the UI.
   */
  private Timer timer;

  /**
   * The IGame instance for which this is the UI.
   */
  private DotsGame game;
  
  /**
   * State variable counts down to zero while flashing 
   * the cells to be collapsed.
   */
  private int flashingState = 0;
  
  /**
   * Cells about to be collapsed are flashed briefly
   * before moving.
   */
  private ArrayList<Descriptor> cellsToCollapse = null;

  /**
   * Flag indicates whether we are currently moving cells down.
   */
  private boolean collapsing = false;
  
  /**
   * Cells currently being moved down during a collapse.
   */
  private ArrayList<AnimatedCell> movingCells = null;

  /**
   * Flag indicates whether we are currently filling new cells.
   */
  private boolean filling = false;
  
  /**
   * New cells filled from top.
   */
  private ArrayList<AnimatedCell> fillingCells = null;

  /**
   * Mouse x coordinate saved for use in paintComponent.
   */
  private int mouseX;
  
  /**
   * Mouse y coordinate saved for use in paintComponent.
   */
  private int mouseY;
  
  /**
   * Constructs a GamePanel with the given game associated ScorePanel.
   * @param game 
   *   the Game instance for which this is the UI
   * @param scorePanel
   *   panel for displaying scores associated with the game
   */
  public GamePanel(DotsGame game, ScorePanel scorePanel)
  {
    this.game = game;
    this.scorePanel = scorePanel;
    addMouseListener(new MyMouseListener());
    addMouseMotionListener(new MyMouseMotionListener());
    timer = new Timer(fallingSpeed , new TimerCallback());
  }
  
  
  // The paintComponent method is invoked by the Swing framework whenever
  // the panel needs to be rendered on the screen.  In this application,
  // repainting is normally triggered by the calls to the repaint() 
  // method in the timer callback and the mouse handlers

  @Override
  public void paintComponent(Graphics g)
  {
    // clear background
    g.setColor(GameMain.BACKGROUND_COLOR);
    g.fillRect(0, 0, getWidth(), getHeight());
    
    // paint occupied cells of the grid
    for (int row = 0; row < game.getHeight(); ++row)
    {
      for (int col = 0; col < game.getWidth(); ++col)
      {
        Dot t = game.getDot(row, col);
        if (t != null)
        { 
          paintOneCell(g, row, col, t);
        }
      }
    }
    
    // highlight selected cells
    ArrayList<Descriptor> selected = game.getSelectionList();
    if (selected.size() >= 2)
    {
      Descriptor prev = selected.get(0);
      for (int i = 1; i < selected.size(); ++i)
      {
        Descriptor curr = selected.get(i);
        highlightOneCell(g, prev.row(), prev.col());
        makeLine(g, prev.col(), prev.row(), curr.col(), curr.row());
        prev = curr;
      }
    }
    if (selected.size() > 0)
    {
      Descriptor c = selected.get(selected.size() - 1);    
      highlightOneCell(g, c.row(), c.col());
      
      // line from last cell to mouse location
      makeLine(g, c.col(), c.row());
    }
    
    // check whether we should flash the disappearing cells
    if (flashingState > 0)
    {
      // need to paint the cells, since they are nulled out the game
      for (Descriptor p : cellsToCollapse)
      {
        // if the release method returned a list, we'll flash them
        // otherwise leave blank during the flashing state
        if (p.getDot().getType() >= 0)
        {
          paintOneCell(g, p.row(), p.col(), p.getDot());

          // if cells are collapsing,flash them
          if (flashingState % 2 != 0)
          {
            highlightOneCell(g, p.row(), p.col());
          }
        }
      }    
    }
    
    // check whether we should be animating the falling cells
    if (collapsing)
    {
      // first grey out the column where cells are moving
      // in order to match the background
      for (AnimatedCell c : movingCells)
      {
        int col = c.col();
        int row = c.row();
        paintOneCell(g, row, col, GameMain.BACKGROUND_COLOR);
      }
      
      for (AnimatedCell c : movingCells)
      {
        int col = c.col();
        int pixel = c.currentPixel;
        paintOneCellByPixel(g, pixel, col, c.getDot());
      }
    }
    
    // check whether we should be animating the new cells from the top
    if (filling)
    {
      // first grey out the column where cells are moving
      for (AnimatedCell c : fillingCells)
      {
        int col = c.col();
        int row = c.row();
        paintOneCell(g, row, col, GameMain.BACKGROUND_COLOR);
      }
      
      for (AnimatedCell c : fillingCells)
      {
        int col = c.col();
        int pixel = c.currentPixel;
        paintOneCellByPixel(g, pixel, col, c.getDot());
      }
      
    }
  }
  
  /**
   * Draws line from center of first cell to center of second
   */
  private void makeLine(Graphics g, int col1, int row1, int col2, int row2)
  {
    int s = GameMain.SIZE;
    int x1 = col1 * s + s / 2;
    int y1 = row1 * s + s / 2;
    int x2 = col2 * s + s / 2;
    int y2 = row2 * s + s / 2;
    g.setColor(Color.BLACK);
    ((Graphics2D) g).setStroke(new BasicStroke(2));
    g.drawLine(x1, y1, x2, y2);
  }

  /**
   * Draws line from center of cell to mouse
   */ 
  private void makeLine(Graphics g, int col1, int row1)
  {
    int s = GameMain.SIZE;
    int x1 = col1 * s + s / 2;
    int y1 = row1 * s + s / 2;
    g.setColor(Color.BLACK);
    ((Graphics2D) g).setStroke(new BasicStroke(2));
    g.drawLine(x1, y1, mouseX, mouseY);
  }

  
  /**
   * Renders a single cell of the grid.
   * 
   * @param g the Swing graphics context
   * @param row y-coordinate of the cell to render
   * @param col x-coordinate of the cell to render
   * @param t the icon to render, normally used
   *   to determine the color with which to render the cell
   */
  private void paintOneCell(Graphics g, int row, int col, Dot t)
  {
    // scale everything up by the SIZE
    int x = GameMain.SIZE * col;
    int y = GameMain.SIZE * row;
    int offset = (GameMain.SIZE - GameMain.DOT_SIZE) / 2;
    g.setColor(getColorForIcon(t));
    g.fillOval(x + offset, y + offset, GameMain.DOT_SIZE, GameMain.DOT_SIZE);
  }

  /**
   * Renders a single cell of the grid.
   * 
   * @param g the Swing graphics context
   * @param row y-coordinate of the cell to render
   * @param col x-coordinate of the cell to render
   * @param color the color to render
   */
  private void paintOneCell(Graphics g, int row, int col, Color color)
  {
    // scale everything up by the SIZE
    int x = GameMain.SIZE * col;
    int y = GameMain.SIZE * row;
    g.setColor(color);
    g.fillRect(x, y, GameMain.SIZE, GameMain.SIZE);
  }

  /**
   * Renders a single cell of the grid specifying its vertical
   * position in pixels.
   * 
   * @param g the Swing graphics context
   * @param rowPixel y-coordinate of pixel at which to render the cell
   * @param col x-coordinate of the cell to render
   * @param t the icon to render, normally used
   *   to determine the color with which to render the cell
   */
  private void paintOneCellByPixel(Graphics g, int rowPixel, int col, Dot t)
  {
    // scale everything up by the SIZE
    int x = GameMain.SIZE * col;
    int y = rowPixel;
    
    int offset = (GameMain.SIZE - GameMain.DOT_SIZE) / 2;
    g.setColor(getColorForIcon(t));
    g.fillOval(x + offset, y + offset, GameMain.DOT_SIZE, GameMain.DOT_SIZE);
  }

  /**
   * Highlights one cell.
   * 
   * @param g the Swing graphics context
   * @param row y-coordinate of the cell to highlight
   * @param col x-coordinate of the cell to highlight
   */
  private void highlightOneCell(Graphics g, int row, int col)
  {
    // highlight by making a black dot that is half the size of the dot
    g.setColor(Color.BLACK);
    int x = GameMain.SIZE * col;
    int y = GameMain.SIZE * row;
    int offset = (GameMain.SIZE - GameMain.DOT_SIZE / 2) / 2;
    g.fillOval(x + offset, y + offset, GameMain.DOT_SIZE/2, GameMain.DOT_SIZE/2);
  }

  /**
   * Listener for timer events.  The actionPerformed method
   * is invoked each time the timer fires and the call to
   * repaint() at the bottom of the method causes the panel
   * to be redrawn.
   */
  private class TimerCallback implements ActionListener
  {
    @Override
    public void actionPerformed(ActionEvent arg0)
    {

      // State may be flashing, collapsing or filling.
      // Timer is not stopped until all cascading collapses are finished.

      if (flashingState == 0 && !collapsing && !filling)
      {
        // Either we are just starting execution of the timer, or
        // have finished a previous collapse and fill and need to check
        // whether there is a cascading collapse. If so,
        // set the flashing state and fall through

        //For DotsGame, cellsToCollapse is initialized in mouse release, there
        // is no findRuns method and no cascading collapses
        //cellsToCollapse = game.findRuns(true);
        
        if (cellsToCollapse.size() != 0)
        {
          // enter the flashing state
          flashingState = numberOfFlashes * 2;
          timer.setDelay(flashingSpeed);
          timer.restart();
          
          // update the score too
          scorePanel.updateScore(game.getScore());
        }
        else
        {
          // nothing more to collapse
          timer.stop();
        }      
      }

      if (flashingState > 0)
      {
        flashingState--;
        if (flashingState == 0)
        {
          // Done flashing, start collapsing
          timer.setDelay(fallingSpeed);
          timer.restart();

          ArrayList<Descriptor> currentMovedCells = new ArrayList<Descriptor>();
          for (int col = 0; col < game.getWidth(); ++col)
          {
            ArrayList<Descriptor> temp = game.collapseColumn(col);
            if (temp != null)
            {
              currentMovedCells.addAll(temp);
            }
          }
          // go into collapsing state
          collapsing = true;
          movingCells = new ArrayList<AnimatedCell>();
          for (Descriptor c : currentMovedCells)
          {
            movingCells.add(new AnimatedCell(c));
          }         
        }
      }

      if (collapsing)
      {
        // see if there are still cells moving 
        boolean found = false;
        for (AnimatedCell cell : movingCells)
        {
          if (!cell.done())
          {
            found = true;
            cell.animate(fallPerFrame);
          }
        }
        if (!found)
        {
          // done collapsing, start filling 
          cellsToCollapse.clear();
          collapsing = false;
          movingCells = null;
          
          initializeCellsToFill();
          filling = true;
          if (fillingCells.size() == 0)
          {
            //System.out.println("WARNING: game returned collapsing cells but failed to return cells to fill columns");
            filling = false;
            fillingCells = null;
          }
        }
      }

      if (filling)
      {
        // see if we're done
        boolean found = false;
        for (AnimatedCell cell : fillingCells)
        {
          if (!cell.done())
          {
            found = true;
            cell.animate(fallPerFrame);
          }
        }
        if (!found)
        {
          // done filling
          filling = false;
          fillingCells = null;
        }
      }

      repaint();
    }
  }
  
  /**
   * Sets up the fillingCells list.
   */
  private void initializeCellsToFill()
  {
    fillingCells = new ArrayList<AnimatedCell>();
    for (int col = 0; col < game.getWidth(); ++col)
    {
      ArrayList<Descriptor> currentNewCells = game.fillColumn(col);
      if (currentNewCells != null)
      {
        for (Descriptor c : currentNewCells)
        {
          fillingCells.add(new AnimatedCell(c, -1));
        }
      }
    }
  }

  /**
   * Returns a color for the given icon.
   * @param icon
   * @return
   */
  private Color getColorForIcon(Dot icon)
  {
    int index = icon.getType();
    if (index < 0)
    {
      return GameMain.BACKGROUND_COLOR;
    }
    else if (index >= GameMain.COLORS.length)
    {
      return Color.BLACK;
    }
    return GameMain.COLORS[index];
  }
  
  /**
   * Callback for mouse events.
   */
  private class MyMouseListener implements MouseListener
  {

    @Override
    public void mouseClicked(MouseEvent event)
    {
    }

    @Override
    public void mousePressed(MouseEvent event)
    {
      if (flashingState > 0 || collapsing || filling) return;
      
      int row = event.getY() / GameMain.SIZE;
      int col = event.getX() / GameMain.SIZE;
      mouseX = event.getX();
      mouseY = event.getY();
      
      //System.out.println(row + ", " + col);
      //currentCell = new Cell(row, col, game.getIcon(row, col));
      game.select(row, col);
      repaint();
    }

    @Override
    public void mouseReleased(MouseEvent event)
    {
      if (flashingState > 0 || collapsing || filling) return;     

      cellsToCollapse = game.release();
      if (cellsToCollapse == null)
      {
        // they're not returning a list of deleted dots, 
        // let's still try to get the information from the grid anyway
        cellsToCollapse = new ArrayList<Descriptor>();
        for (int row = 0; row < game.getHeight(); row += 1)
        {
          for (int col = 0; col < game.getWidth(); col += 1)
          {
            Dot d = game.getDot(row, col);
            if (d == null)
            {
              cellsToCollapse.add(new Descriptor(row, col, new Dot(-1)));
            }
          }
        }
      }
      
      if (cellsToCollapse != null && cellsToCollapse.size() > 0)
      {
        // Successful move, start up the timer
        timer.setDelay(flashingSpeed);
        timer.restart();
      }
     
      repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
    }
  }
  
  /**
   * Callback for mouse motion events.
   */
  private class MyMouseMotionListener implements MouseMotionListener
  {

    @Override
    public void mouseDragged(MouseEvent e)
    {
      mouseX = e.getX();
      mouseY = e.getY();

      int row = e.getY() / GameMain.SIZE;
      int col = e.getX() / GameMain.SIZE;
      

      if (row >= 0 && col >= 0 && row < game.getHeight() && col < game.getWidth())
      {
        game.select(row, col);
      }
      repaint();

    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
    }
    
  }
  
  /**
   * Subclass of Cell that keeps track of a current vertical
   * offset at which it should actually be drawn.
   */
  private class AnimatedCell extends Descriptor
  {
    public int startPixel; // pixel coordinates
    public int endPixel;
    public int currentPixel;
    
    /**
     * Constructs an AnimatedCell with the same attributes
     * as the given Cell, with a starting location determined
     * by the cell's previous row.
     * @param cell
     */
    public AnimatedCell(Descriptor cell)
    {
      super(cell.row(), cell.col(), cell.getDot());
      startPixel = cell.getPreviousRow() * GameMain.SIZE;
      currentPixel = startPixel;
      endPixel = cell.row() * GameMain.SIZE;
    }

    /**
     * Constructs an AnimatedCell with the same attributes
     * as the given Cell, with a starting location determined
     * by the given starting row.
     * @param cell
     */
    public AnimatedCell(Descriptor cell, int startRow)
    {
      super(cell.row(), cell.col(), cell.getDot());
      this.setPreviousRow(startRow);
      startPixel = startRow * GameMain.SIZE;
      currentPixel = startPixel;
      endPixel = cell.row() * GameMain.SIZE;
    }

    /**
     * Determines whether this cell has reached its
     * ending location.
     * @return
     */
    public boolean done()
    {
      return currentPixel == endPixel;
    }
    
    /**
     * Moves this cell's current position by the given amount.
     * @param pixels
     */
    public void animate(int pixels)
    {
      currentPixel += pixels;
      if (currentPixel > endPixel)
      {
        currentPixel = endPixel;
      }
    }
  }
}
