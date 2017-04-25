/**
 *
 */

package playercontrollertest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import model.Puzzle;

import org.junit.Test;

import playercontroller.HumanPlayer;

/**
 * @author Martin Lutta Putra (13515121).
 *
 * 
 */
public class HumanPlayerTest {

  @Test
  public void test() {
    byte size = (byte) 5;
    Puzzle p = new Puzzle(size);
    HumanPlayer hp = new HumanPlayer(p);
    assertTrue(HumanPlayer.playerCount != 0);
    assertTrue(hp.getPlayerId() == HumanPlayer.playerCount);
    assertTrue(hp.isRunning());
    assertNotNull(hp.getBoard());
    assertNotNull(hp.getMovementLabel());
    assertTrue(hp.getMovementLabel().getText().contains("Movement"));
  }

}
