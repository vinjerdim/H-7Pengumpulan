/**
 *
 */

package modecontrollertest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import modecontroller.VsPlayerMode;

import org.junit.Test;

/**
 * @author Martin Lutta Putra (13515121).
 *
 * 
 */
public class VsPlayerModeTest {

  @Test
  public void test() {
    VsPlayerMode vpm = new VsPlayerMode(1);
    assertTrue(!vpm.getPuzzle().isFinished() && vpm.getPuzzle().isSolvable());
    assertNotNull(vpm.getPlayer1());
    assertNotNull(vpm.getPlayer1Thread());
    assertNotNull(vpm.getPlayer2());
    vpm.initializePlayer2();
    assertTrue(vpm.getPlayer2Thread().getName().contains("Player"));
    vpm.startGame();
    assertNotNull(vpm.getMonitorTimer());
    assertNotNull(vpm.getSwitchingTimer());
  }

}
