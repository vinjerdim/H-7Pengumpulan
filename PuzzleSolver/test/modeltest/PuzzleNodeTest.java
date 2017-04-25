package modeltest;

import static org.junit.Assert.*;

import org.junit.Test;
import model.*;

public class PuzzleNodeTest {

	@Test
	public void test() {
		byte testsize = (byte) 5;
		Puzzle P = new Puzzle(testsize);
		PuzzleNode NP = new PuzzleNode(P);
		assertEquals(P, NP.getCurrentPuzzle());
		assertNull(NP.getPrevious());
		assertEquals(NP.getDepthCost(), NP.getMovement().length);
		assertTrue(NP.getMovement().length == 0);
	}
}
