/**
 *
 */
package controllertest;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.VsPlayerMode;

/**
 * @author Martin Lutta Putra (13515121).
 *
 * 
 */
public class VsPlayerModeTest {

  @Test
  public void test() {
    VsPlayerMode VPM = new VsPlayerMode();
    assertTrue(!VPM.getPuzzle().isFinished() && VPM.getPuzzle().isSolvable());
    assertNotNull(VPM.getPlayer1());
    assertNotNull(VPM.getPlayer1Thread());
    assertNotNull(VPM.getStartButton());
    assertNotNull(VPM.getPlayer2());
    assertTrue(VPM.getTurn() == 1);
    VPM.initializePlayer2();
    assertTrue(VPM.getPlayer2Thread().getName().contains("Player"));
    VPM.startGame();
    assertNotNull(VPM.getMonitorTimer());
    assertNotNull(VPM.getSwitchingTimer());
  }

}
