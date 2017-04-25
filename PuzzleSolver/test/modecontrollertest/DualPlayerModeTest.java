/**
 *
 */

package modecontrollertest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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
    DualPlayerMode dp = new DualPlayerMode();
    assertTrue(!dp.getPuzzle().isFinished() && dp.getPuzzle().isSolvable());
    assertNotNull(dp.getPlayer1());
    assertNotNull(dp.getPlayer1Thread());
    assertNull(dp.getPlayer2());
    assertNull(dp.getPlayer2Thread());
  }
}
