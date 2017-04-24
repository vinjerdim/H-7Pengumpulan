/**
 *
 */
package puzzletest;

import static org.junit.Assert.*;

import org.junit.Test;
import model.PuzzleSolver;
import model.Puzzle;
import model.PuzzleNode;
/**
 * @author Martin Lutta Putra (13515121).
 *
 * 
 */
public class PuzzleSolverTest {

	@Test
	public void test() {
		byte size = (byte) 5;
		Puzzle P = new Puzzle(size);
		PuzzleNode PN = new PuzzleNode(P);
		PuzzleSolver PS = new PuzzleSolver(P);
		assertNull(PS.getDeclarationSolution());
		assertNotNull(PS.getCurrent());
	}
}
