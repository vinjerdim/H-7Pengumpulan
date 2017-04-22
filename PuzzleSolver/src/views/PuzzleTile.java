/**
 * PuzzleTile terdiri dari petak-petak yang membentuk sebuah puzzle 
 */

package views;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import puzzle.Puzzle;

/**
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public class PuzzleTile extends JPanel {
  private Tile[] tiles;
  
  /**
   * 
   * @param puzzle Puzzle yang akan digambar.
   */
  public PuzzleTile(final Puzzle puzzle) {
    int size = puzzle.getSize();
    int length = Tile.getDefaultSize() * size;
    setPreferredSize(new Dimension(length, length));
    GridLayout layout = new GridLayout(size, size, 1, 1);
    setLayout(layout);
    
    tiles = new Tile[puzzle.getMaxValue()];
    for (byte i = 0; i < puzzle.getMaxValue(); i++) {
      String value = (puzzle.getValue(i) != puzzle.getMaxValue()) ? puzzle.getValue(i) + "" : "";
      tiles[i] = new Tile(value);
      add(tiles[i]);
    }
  }
}
