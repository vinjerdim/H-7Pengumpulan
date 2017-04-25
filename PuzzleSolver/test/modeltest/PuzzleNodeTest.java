package modeltest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import model.Puzzle;
import model.PuzzleNode;

import org.junit.Test;

public class PuzzleNodeTest {

  @Test
  public void test() {
    byte testsize = (byte) 5;
    Puzzle p = new Puzzle(testsize);
    PuzzleNode np = new PuzzleNode(p);
    assertEquals(p, np.getCurrentPuzzle());
    assertNull(np.getPrevious());
    assertEquals(np.getDepthCost(), np.getMovement().length);
    assertTrue(np.getMovement().length == 0);
  }
}
