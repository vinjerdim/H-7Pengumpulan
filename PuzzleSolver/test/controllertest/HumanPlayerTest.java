/**
 *
 */
package controllertest;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.DualPlayerMode;
import controller.PlayerController;
import model.Puzzle;
import controller.HumanPlayer;
/**
 * @author Martin Lutta Putra (13515121).
 *
 * 
 */
public class HumanPlayerTest {

  @Test
  public void test() {
    byte size = (byte) 5;
    Puzzle P = new Puzzle(size);
    HumanPlayer HP = new HumanPlayer(P);
    assertTrue(HP.playerCount != 0);
    assertTrue(HP.getPlayerID() == HP.playerCount);
    assertFalse(HP.getRunningState());
    assertNotNull(HP.getBoard());
    assertNotNull(HP.getMovementLabel());
    assertTrue(HP.getMovementLabel().getText().contains("Movement"));
  }

}
