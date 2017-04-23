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
  private Puzzle puzzle;
  private int puzzleSize;
  
  /**
   * 
   * @param puzzle Puzzle yang akan digambar.
   */
  public PuzzleTile(final Puzzle puzzle) {
    this.puzzle = new Puzzle(puzzle);
    int size = puzzle.getSize();
    puzzleSize = Tile.getDefaultSize() * size;
    setPreferredSize(new Dimension(puzzleSize, puzzleSize));
    GridLayout layout = new GridLayout(size, size, 1, 1);
    setLayout(layout);    
    
    tiles = new Tile[puzzle.getMaxValue()];
    placeTiles();
  }
  
  public int getPuzzleTileSize() {
    return puzzleSize;
  }
  
  /**
   * Menghapus semua tile.
   */
  public void removeTiles() {
    for (byte i = 0; i < tiles.length; i++) {
      remove(tiles[i]);
    }
  }
  
  /**
   * Menggambar tile sesuai konfigurasi dari kelas Puzzle.
   */
  public void placeTiles() {
    for (byte i = 0; i < tiles.length; i++) {
      String value = (puzzle.getValue(i) != puzzle.getMaxValue()) ? puzzle.getValue(i) + "" : "";
      tiles[i] = new Tile(value);
      add(tiles[i]);
    }
  }
  
  public boolean isMovableTo(int direction) {
    return puzzle.isMovableTo(direction);
  }
  
  /**
   * 
   * @param direction Arah pergerakan petak kosong (1: atas, 2: bawah, 3: kiri, 4: kanan).
   */
  public void moveTo(int direction) {
    puzzle.moveTo(direction);
    removeTiles();
    placeTiles();
  }
  
  public boolean isFinished() {
    return puzzle.isFinished();
  }
}