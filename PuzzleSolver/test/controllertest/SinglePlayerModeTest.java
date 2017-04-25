/**
 *
 */

package controllertest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import modecontroller.SinglePlayerMode;

import org.junit.Test;



/**
 * @author Martin Lutta Putra (13515121).
 *
 * 
 */
public class SinglePlayerModeTest {

  @Test
  public void test() {
    SinglePlayerMode dp = new SinglePlayerMode();
    assertTrue(!dp.getPuzzle().isFinished() && dp.getPuzzle().isSolvable());
    assertNotNull(dp.getPlayer1());
    assertNotNull(dp.getPlayer1Thread());
  }

}
