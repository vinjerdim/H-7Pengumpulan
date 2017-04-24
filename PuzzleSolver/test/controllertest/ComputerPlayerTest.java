package controllertest;

import static org.junit.Assert.*;

import org.junit.Test;
import model.Puzzle;
import model.PuzzleSolver;
import controller.*;

public class ComputerPlayerTest {

	@Test
	public void test() {
		byte size = (byte) 5;
		Puzzle P = new Puzzle(size);
		ComputerPlayer CP = new ComputerPlayer(P);
		assertTrue(CP.getMovementIndex() == 0);
		assertEquals(CP.getSolution(), (new PuzzleSolver(P)).getSolution().getMovementSet());		
	}
}
