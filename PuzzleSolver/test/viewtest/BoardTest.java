/**
 *
 */
package viewtest;

import static org.junit.Assert.*;

import org.junit.Test;
import views.Board;
import views.Tile;
import model.Puzzle;

/**
 * @author Martin Lutta Putra (13515121).
 *
 * 
 */
public class BoardTest {

	@Test
	public void test() {
		byte size = (byte) 5;
		Puzzle P = new Puzzle(size);
		Board B = new Board(P);
		assertTrue(B.getPuzzleTileSize() == Tile.getDefaultSize() * size);
		assertTrue(B.getMovementCount() == 0);
		assertEquals(B.getPuzzle(), P);
		for (int i = 0; i < B.getTiles().length; i++) {
			assertTrue(0 <= B.getTiles()[i].getTileValue());
			assertTrue(B.getTiles()[i].getTileValue() <= B.getPuzzle().getMaxValue());
		}
	}

}
