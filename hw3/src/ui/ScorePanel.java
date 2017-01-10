package ui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * Panel for displaying the score in a simple video game.
 */
public class ScorePanel extends JPanel
{
  /**
   * Format string for displaying score.
   */
  private static final String SCORE_FORMAT = "Score: %1d";

  /**
   * Score to be displayed.
   */
  private int score;

  /**
   * Sets the score to be displayed in this panel.
   * @param newScore
   *   score to be displayed
   */
  public void updateScore(int newScore)
  {
    this.score = newScore;
    repaint();
  }

  @Override
  public void paintComponent(Graphics g)
  {
    Dimension d = getPreferredSize();
    ((Graphics2D) g).setBackground(Color.WHITE);
    g.clearRect(0, 0, d.width, d.height);
    Font font = new Font(Font.SANS_SERIF, Font.PLAIN, GameMain.SCORE_FONT);
    g.setFont(font);
    FontMetrics metrics = g.getFontMetrics(font);
    String text = String.format(SCORE_FORMAT, score);
    int width = metrics.stringWidth(text);
    int x = (d.width - width) / 2;
    int y = (d.height) / 2; 

    g.drawString(text, x, y);
  }
}
