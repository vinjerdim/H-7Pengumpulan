/**
 *
 */

package controllertest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Timer;

import modecontroller.DualPlayerMode;

import org.junit.Test;

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
    assertNull(DP.getPlayer2());
    assertNull(DP.getPlayer2Thread());
  }
}
