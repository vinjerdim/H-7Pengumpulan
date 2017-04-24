/**
 *
 */
package puzzletest;

import static org.junit.Assert.*;
import org.junit.Test;
import model.Puzzle;

/**
 * @author Martin Lutta Putra (13515121).
 *
 * 
 */
public class PuzzleTest {

  @Test
  public void test() {
    byte testsize = (byte) 5;
    Puzzle P = new Puzzle(testsize);
    assertTrue(P.getSize() == testsize);
    assertTrue(0 <= P.getBlankLocation() && P.getBlankLocation() < P.getMaxValue() );
    assertTrue(P.getMaxValue() == testsize*testsize);
    for (int i = 0; i < P.getMaxValue(); i++) {
      assertTrue(0 <= P.getValue(i) && P.getValue(i) <= P.getMaxValue());
    }
  }

}
