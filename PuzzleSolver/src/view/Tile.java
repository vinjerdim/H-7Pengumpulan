/**
 * Tile merupakan petak-petak pada puzzle. 
 */

package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public class Tile extends JButton {
  private static final int defaultSize = 50;
  private int tileValue;
  
  /**
   * 
   * @param value text yang akan ditampilkan pada petak.
   */
  public Tile(int value, int maxValue) {
    tileValue = value;
    setPreferredSize(new Dimension(defaultSize, defaultSize));
    setLayout(new BorderLayout());
    
    if (value != maxValue) {
      JLabel number = new JLabel(value + "", JLabel.CENTER);
      add(number);
    }
  }
  
  public static int getDefaultSize() {
    return defaultSize;
  }
  
  public int getTileValue() {
    return tileValue;
  }
}
