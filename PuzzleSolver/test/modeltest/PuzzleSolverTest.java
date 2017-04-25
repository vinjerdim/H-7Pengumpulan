/**
 *
 */

package modeltest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import model.Puzzle;
import model.PuzzleSolver;

import org.junit.Test;

/**
 * @author Martin Lutta Putra (13515121).
 *
 * 
 */
public class PuzzleSolverTest {

  @Test
  public void test() {
    byte size = (byte) 5;
    Puzzle p = new Puzzle(size);
    PuzzleSolver ps = new PuzzleSolver(p);
    assertNull(ps.getDeclarationSolution());
    assertNotNull(ps.getCurrent());
  }
}
