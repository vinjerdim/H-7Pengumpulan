/**
 * Tile merupakan petak-petak pada puzzle. 
 */

package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public class Tile extends JPanel{
  private static final int defaultSize = 50;
  /**
   * 
   * @param tileSize ukuran petak.
   */
  public Tile(String value) {
    setPreferredSize(new Dimension(defaultSize, defaultSize));
    setLayout(new BorderLayout());
    
    if (!value.equals("")) {
      Border border = BorderFactory.createLineBorder(Color.GRAY, 3);
      setBorder(border);
      JLabel number = new JLabel(value, JLabel.CENTER);
      add(number);
    }    
  }
  
  public static int getDefaultSize() {
    return defaultSize;
  }
}
