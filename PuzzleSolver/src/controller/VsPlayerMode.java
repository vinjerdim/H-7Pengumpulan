/**
 * 
 */

package controller;

import java.awt.BorderLayout;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public class VsPlayerMode extends DualPlayerMode {
  private static int turn = 1;
  private Timer switchingTimer;
  
  /**
   * Konstruktor untuk frame player versus player.
   */
  public VsPlayerMode() {
    // TODO Auto-generated constructor stub
    super();
    player2 = new HumanPlayer(puzzle);
    player2Thread = new Thread(player2);
    
    add(player2, BorderLayout.LINE_END);
    player2.enablePlayer(false);
    
    pack();
    setVisible(true);
    setResizable(false);
  }
  
  @Override
  public void startGame() {
    super.startGame();
    switchingTimer = new Timer(true);
    TimerTask switchTurn = new SwitchTurn();
    switchingTimer.scheduleAtFixedRate(switchTurn, 0, 5000);
  }
  
  private class SwitchTurn extends TimerTask {
    @Override
    public void run() {
      // TODO Auto-generated method stub
      if (player1Thread.isAlive() && player2Thread.isAlive()) {
        player1.enablePlayer(player1.getPlayerID() == turn);
        player2.enablePlayer(player2.getPlayerID() == turn);
        turn %= PlayerController.playerCount;
        turn++;
      } else {
        switchingTimer.cancel();
      }
    }
  }
}
