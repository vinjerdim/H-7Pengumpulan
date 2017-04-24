/**
 * PuzzleTile terdiri dari petak-petak yang membentuk sebuah puzzle 
 */

package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.Puzzle;

/**
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public class Board extends JPanel implements MouseListener {
  private Tile[] tiles;
  private Puzzle puzzle;
  private int puzzleSize;
  private int movement = 0;
  
  /**
   * 
   * @param puzzle Puzzle yang akan digambar.
   */
  public Board(final Puzzle puzzle) {
    this.puzzle = new Puzzle(puzzle);
    int size = puzzle.getSize();
    puzzleSize = Tile.getDefaultSize() * size;
    setPreferredSize(new Dimension(puzzleSize, puzzleSize));
    setLayout(new GridLayout(size, size));
    
    Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
    setBorder(border);
    
    tiles = new Tile[puzzle.getMaxValue()];
    placeTiles();
    setTilesEnabled(true);
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
    int maxValue = puzzle.getMaxValue();
    for (byte i = 0; i < tiles.length; i++) {
      int currentValue = puzzle.getValue(i);
      tiles[i] = new Tile(currentValue, maxValue);
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
  public void moveTo(int direction, boolean enabled) {
    puzzle.moveTo(direction);
    removeTiles();
    placeTiles();
    setTilesEnabled(!isFinished() && enabled);
  }
  
  public boolean isFinished() {
    return puzzle.isFinished();
  }
  
  public int getTileIndex(Tile tile) {
    int i = 0;
    boolean found = false;
    while (i < tiles.length && !found) {
      if (tiles[i] == tile) {
        found = true;
      } else {
        i++;
      }
    }
    return (found) ? i : -1;
  }
  
  public int getNextMove(Tile tile) {
    int current = getTileIndex(tile);
    int size = puzzle.getSize();
    int maxValue = puzzle.getMaxValue();
    if (current - size >= 0 && tiles[current - size].getTileValue() == maxValue) {
      return 2;
    } else if (current + size < maxValue && tiles[current + size].getTileValue() == maxValue) {
      return 1;
    } else if (current - 1 >= 0 && (current - 1) % size < current % size 
        && tiles[current - 1].getTileValue() == maxValue) {
      return 4;
    } else if (current + 1 < maxValue && (current + 1) % size > current % size 
        && tiles[current + 1].getTileValue() == maxValue) {
      return 3;
    } else {
      return 0;
    }
  }
  
  public int getMovementCount() {
    return movement;
  }
  
  public void setTilesEnabled(boolean enabled) {
    for (int i = 0; i < tiles.length; i++) {
      tiles[i].setEnabled(enabled);
      if (enabled) {
        tiles[i].addMouseListener(this);
      } else {
        tiles[i].removeMouseListener(this);
      } 
    }
  }
  
  @Override
  public void mouseClicked(MouseEvent e) {
    // TODO Auto-generated method stub
    Tile current = (Tile) e.getComponent();
    int move = getNextMove(current);
    if (move != 0) {
      setVisible(false);
      moveTo(move, true);
      setVisible(true);
      movement++;
    }
  }
  
  @Override
  public void mouseEntered(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mouseExited(MouseEvent arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mousePressed(MouseEvent arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mouseReleased(MouseEvent arg0) {
    // TODO Auto-generated method stub
    
  }
}