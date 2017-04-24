/**
 *
 */
package controllertest;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.SinglePlayerMode;

/**
 * @author Martin Lutta Putra (13515121).
 *
 * 
 */
public class SinglePlayerModeTest {

  @Test
  public void test() {
    SinglePlayerMode DP = new SinglePlayerMode();
    assertTrue(!DP.getPuzzle().isFinished() && DP.getPuzzle().isSolvable());
    assertNotNull(DP.getPlayer1());
    assertNotNull(DP.getPlayer1Thread());
    assertNotNull(DP.getStartButton());
  }

}
