/**
 *
 */

package modecontrollertest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import modecontroller.VsComputerMode;

import org.junit.Test;

/**
 * @author Martin Lutta Putra (13515121).
 *
 * 
 */
public class VsComputerModeTest {

  @Test
  public void test() {
    VsComputerMode vcm = new VsComputerMode();
    assertTrue(!vcm.getPuzzle().isFinished() && vcm.getPuzzle().isSolvable());
    assertNotNull(vcm.getPlayer1());
    assertNotNull(vcm.getPlayer1Thread());
    assertNotNull(vcm.getPlayer2());
    vcm.initializePlayer2();
    assertTrue(vcm.getPlayer2Thread().getName().contains("Player"));
    vcm.startGame();
    assertNotNull(vcm.getMonitorTimer());
  }
}
