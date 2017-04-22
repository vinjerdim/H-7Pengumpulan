/**
 * Tile merupakan petak-petak pada puzzle. 
 */


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
  private int number;
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
      number = Integer.parseInt(value);
      JLabel numberLabel = new JLabel(number, JLabel.CENTER);
      add(numberLabel);
    }
    else {
      number = 0;
    }
  }
  
  public static int getDefaultSize() {
    return defaultSize;
  }
}
