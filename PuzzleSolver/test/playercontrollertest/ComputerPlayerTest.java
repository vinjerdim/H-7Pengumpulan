package playercontrollertest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import model.Puzzle;

import org.junit.Test;

import playercontroller.ComputerPlayer;

public class ComputerPlayerTest {

  @Test
  public void test() {
    byte size = (byte) 3;
    Puzzle p = new Puzzle(size);
    ComputerPlayer cp = new ComputerPlayer(p, 1);
    assertTrue(cp.getMovementIndex() == 0);
    assertEquals(cp.getDelayTime(), 1);
  }
}
