package playercontrollertest;

import static org.junit.Assert.assertEquals;

import model.Puzzle;

import org.junit.Test;

import playercontroller.ComputerPlayer;

public class ComputerPlayerTest {

  @Test
  public void test() {
    byte size = (byte) 3;
    Puzzle p = new Puzzle(size);
    ComputerPlayer cp = new ComputerPlayer(p, 1);
    assertEquals(cp.getDelayTime(), 1);
  }
}
