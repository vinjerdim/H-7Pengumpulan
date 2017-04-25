/**
 *
 */

package viewtest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import model.Puzzle;

import org.junit.Test;

import view.Board;
import view.Tile;


/**
 * @author Martin Lutta Putra (13515121).
 *
 * 
 */
public class BoardTest {

  @Test
  public void test() {
    byte size = (byte) 5;
    Puzzle p = new Puzzle(size);
    Board b = new Board(p);
    assertTrue(b.getPuzzleTileSize() == Tile.getDefaultSize() * size);
    assertTrue(b.getMovementCount() == 0);
    assertEquals(b.getPuzzle(), p);
    for (int i = 0; i < b.getTiles().length; i++) {
      assertTrue(0 <= b.getTiles()[i].getTileValue());
      assertTrue(b.getTiles()[i].getTileValue() <= b.getPuzzle().getMaxValue());
    }
  }

}
