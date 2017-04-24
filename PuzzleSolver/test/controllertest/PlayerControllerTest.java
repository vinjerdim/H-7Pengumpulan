/**
 *
 */
package controllertest;

import static org.junit.Assert.*;

import org.junit.Test;
import model.Puzzle;
import controller.PlayerController;
/**
 * @author Martin Lutta Putra (13515121).
 *
 * 
 */
public class PlayerControllerTest {

  @Test
  public void test() {
    byte size = (byte) 5;
    Puzzle P = new Puzzle(size);
    PlayerController PC = new PlayerController(P);
    assertTrue(PC.playerCount != 0);
    assertTrue(PC.getPlayerID() == PC.playerCount);
    assertFalse(PC.getRunningState());
    assertNotNull(PC.getBoard());
    assertNotNull(PC.getMovementLabel());
  }
}
