/**
 *
 */

package playercontrollertest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import model.Puzzle;

import org.junit.Test;

import playercontroller.PlayerController;

/**
 * @author Martin Lutta Putra (13515121).
 *
 * 
 */
public class PlayerControllerTest {

  @Test
  public void test() {
    byte size = (byte) 5;
    Puzzle p = new Puzzle(size);
    PlayerController pc = new PlayerController(p);
    assertTrue(PlayerController.playerCount != 0);
    assertTrue(pc.getPlayerId() == PlayerController.playerCount);
    assertTrue(pc.isRunning());
    assertNotNull(pc.getBoard());
    assertNotNull(pc.getMovementLabel());
  }
}
