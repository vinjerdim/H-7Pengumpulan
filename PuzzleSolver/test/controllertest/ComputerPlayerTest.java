package controllertest;

import static org.junit.Assert.*;

import model.Puzzle;

import org.junit.Test;

import playercontroller.ComputerPlayer;

public class ComputerPlayerTest {

  @Test
  public void test() {
    byte size = (byte) 5;
    Puzzle p = new Puzzle(size);
    ComputerPlayer cp = new ComputerPlayer(p);
  }
}
