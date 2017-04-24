package puzzletest;

import static org.junit.Assert.*;
import model.*;

import org.junit.Test;

public class PuzzleNodeComparatorTest {

  @Test
  public void test() {
    byte size = (byte) 5;
    Puzzle P = new Puzzle(size);
    PuzzleNode PN1 = new PuzzleNode(P);
    PuzzleNode PN2 = new PuzzleNode(P);
    PuzzleNodeComparator PNC = new PuzzleNodeComparator();
    assertTrue(0 <= PNC.compare(PN1, PN2) && PNC.compare(PN1, PN2) <= 2);
  }

}
