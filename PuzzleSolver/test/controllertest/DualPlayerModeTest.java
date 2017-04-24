/**
 *
 */
package controllertest;

import static org.junit.Assert.*;

import java.util.Timer;

import org.junit.Test;
import controller.DualPlayerMode;

/**
 * @author Martin Lutta Putra (13515121).
 *
 * 
 */
public class DualPlayerModeTest {

  @Test
  public void test() {
    DualPlayerMode DP = new DualPlayerMode();
    assertTrue(!DP.getPuzzle().isFinished() && DP.getPuzzle().isSolvable());
    assertNotNull(DP.getPlayer1());
    assertNotNull(DP.getPlayer1Thread());
    assertNotNull(DP.getStartButton());
    assertNull(DP.getPlayer2());
    assertNull(DP.getPlayer2Thread());
  }
}
