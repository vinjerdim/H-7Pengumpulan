package playercontrollertest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import model.Puzzle;
import model.PuzzleSolver;

import org.junit.Test;

import playercontroller.ComputerPlayer;


public class ComputerPlayerTest {

  @Test
  public void test() {
    byte size = (byte) 5;
    Puzzle p = new Puzzle(size);
    ComputerPlayer cp = new ComputerPlayer(p);
    assertTrue(cp.getMovementIndex() == 0);
    assertEquals(cp.getSolution(), (new PuzzleSolver(p)).getSolution().getMovementSet());
  }
}
