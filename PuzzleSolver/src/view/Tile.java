package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 * Kelas Tile merupakan petak-petak pada puzzle.
 * 
 * @author Marvin Jerremy Budiman (13515076).
 */
public class Tile extends JButton {
  private static final int defaultSize = 50;
  private int tileValue;
  
  /**
   * Konstruktor kelas Tile dengan parameter value dan maxValue
   * 
   * @param value Nilai untuk suatu tile
   * @param maxValue Nilai maksimal untuk suatu tile
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
  
  /**
   * Method yang mengembalikan nilai defaultSize
   * 
   * @return Nilai dari defaultSize
   */
  public static int getDefaultSize() {
    return defaultSize;
  }
  
  /**
   * Method yang mengembalikan nilai tileValue
   * 
   * @return Nilai dari tileValue
   */
  public int getTileValue() {
    return tileValue;
  }
}
