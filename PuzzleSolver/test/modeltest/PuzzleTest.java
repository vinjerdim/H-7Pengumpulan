/**
 *
 */

package modeltest;

import static org.junit.Assert.assertTrue;

import model.Puzzle;

import org.junit.Test;


/**
 * @author Martin Lutta Putra (13515121).
 *
 * 
 */
public class PuzzleTest {

  @Test
  public void test() {
    byte testsize = (byte) 5;
    Puzzle p = new Puzzle(testsize);
    assertTrue(p.getSize() == testsize);
    assertTrue(0 <= p.getBlankLocation() && p.getBlankLocation() < p.getMaxValue());
    assertTrue(p.getMaxValue() == testsize * testsize);
    for (int i = 0; i < p.getMaxValue(); i++) {
      assertTrue(0 <= p.getValue(i) && p.getValue(i) <= p.getMaxValue());
    }
  }

}
