package modeltest;

import static org.junit.Assert.assertTrue;

import model.Puzzle;
import model.PuzzleNode;
import model.PuzzleNodeComparator;

import org.junit.Test;

public class PuzzleNodeComparatorTest {

  @Test
  public void test() {
    byte size = (byte) 5;
    Puzzle p = new Puzzle(size);
    PuzzleNode pn1 = new PuzzleNode(p);
    PuzzleNode pn2 = new PuzzleNode(p);
    PuzzleNodeComparator pnc = new PuzzleNodeComparator();
    assertTrue(0 <= pnc.compare(pn1, pn2) && pnc.compare(pn1, pn2) <= 2);
  }

}
