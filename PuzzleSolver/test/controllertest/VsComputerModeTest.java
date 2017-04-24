/**
 *
 */
package controllertest;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.VsComputerMode;

/**
 * @author Martin Lutta Putra (13515121).
 *
 * 
 */
public class VsComputerModeTest {

	@Test
	public void test() {
		VsComputerMode VCM = new VsComputerMode();
		assertTrue(!VCM.getPuzzle().isFinished() && VCM.getPuzzle().isSolvable());
		assertNotNull(VCM.getPlayer1());
		assertNotNull(VCM.getPlayer1Thread());
		assertNotNull(VCM.getStartButton());
		assertNotNull(VCM.getPlayer2());
		VCM.initializePlayer2();
		assertTrue(VCM.getPlayer2Thread().getName().contains("Player"));
		VCM.startGame();
		assertNotNull(VCM.getMonitorTimer());
	}
}
