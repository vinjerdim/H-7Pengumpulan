/**
 *
 */

package controllertest;

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
    assertTrue(hp.playerCount != 0);
    assertTrue(hp.getPlayerID() == hp.playerCount);
    assertTrue(hp.isRunning());
    assertNotNull(hp.getBoard());
    assertNotNull(hp.getMovementLabel());
    assertTrue(hp.getMovementLabel().getText().contains("Movement"));
  }

}
