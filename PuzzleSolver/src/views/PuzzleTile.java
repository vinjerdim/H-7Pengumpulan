/**
 * PuzzleTile terdiri dari petak-petak yang membentuk sebuah puzzle 
 */


import java.awt.event.*;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;


/**
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public class PuzzleTile extends JPanel implements KeyListener{
  private Tile[] tiles;
  private Puzzle puzzle;
  private int blankLocation;
  
  /**
   * 
   * @param puzzle Puzzle yang akan digambar.
   */
  public PuzzleTile(final Puzzle puzzle) {
    this.puzzle = puzzle;
    int size = puzzle.getSize();
    int length = Tile.getDefaultSize() * size;
    setPreferredSize(new Dimension(length, length));
    GridLayout layout = new GridLayout(size, size, 1, 1);
    setLayout(layout);
    
    tiles = new Tile[puzzle.getMaxValue()];
    placeTiles();
  }
  
  public void removeTiles() {
    for (byte i = 0; i < tiles.length; i++) {
      remove(tiles[i]);
    }
  }
  
  public void placeTiles() {
    for (byte i = 0; i < tiles.length; i++) {
      String value = (puzzle.getValue(i) != puzzle.getMaxValue()) ? puzzle.getValue(i) + "" : "";
      tiles[i] = new Tile(value);
      add(tiles[i]);
    }
  }
  
<<<<<<< HEAD

  public void keyPressed(KeyEvent e) {
     if(e.getKeyCode() == KeyEvent.VK_ENTER){
        Tile temp = new Tile("10");
        temp = tiles[1];
        tiles[1] = tiles[9];
        tiles[9] = temp;
     }
  }
  public void keyTyped(KeyEvent e) {}
  public void keyReleased(KeyEvent e) {}
  
  
}
=======
  public void moveTo(int direction) {
    puzzle.moveTo(direction);
    removeTiles();
    placeTiles();
  }
}
>>>>>>> 9a5ccad0a4cf179122e2acd1906eb6986306bd0d
