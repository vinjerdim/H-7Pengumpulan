/**
 * 
 */

package modecontroller;

import java.util.Timer;
import java.util.TimerTask;

import playercontroller.HumanPlayer;

/**
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public class VsPlayerMode extends DualPlayerMode {
  private static int turn;
  private Timer switchingTimer;
  
  /**
   * Konstruktor untuk frame player versus player.
   */
  public VsPlayerMode() {
    // TODO Auto-generated constructor stub
    super();
    player2 = new HumanPlayer(puzzle);
    initializePlayer2();
  }
  
  public int getTurn() {
    return turn;
  }
  
  public Timer getSwitchingTimer() {
    return switchingTimer;
  }
  
  @Override
  public void startGame() {
    turn = 1;
    super.startGame();
    switchingTimer = new Timer("Switcher", true);
    TimerTask switchTurn = new SwitchTurn();
    switchingTimer.scheduleAtFixedRate(switchTurn, 0, 5000);
  }
  
  private class SwitchTurn extends TimerTask {
    @Override
    public void run() {
      // TODO Auto-generated method stub
      if (player1.isRunning() && player2.isRunning()) {
        if (turn == 1) {
          statusLabel.setText("Player 1 is active");
        } else {
          statusLabel.setText("Player 2 is active");
        }
        player1.enablePlayer(turn == 1);
        player2.enablePlayer(turn == 2);
        turn %= 2;
        turn++;
      } else {
        switchingTimer.cancel();
      }
    }
  }
}
