/**
 * 
 */

package framecontroller;

import java.awt.BorderLayout;
import java.util.Timer;
import java.util.TimerTask;

import playercontroller.PlayerController;

/**
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public class DualPlayerMode extends FrameMode {
  protected PlayerController player2;
  protected Thread player2Thread;
  private Timer monitorTimer;
  
  /**
   * Konstruktor frame dual player.
   */
  public DualPlayerMode() {
    super("Dual Player Mode");
    add(player1, BorderLayout.LINE_START);
  }
  
  public PlayerController getPlayer2() {
	  return player2;
  }
  
  public Thread getPlayer2Thread() {
	  return player2Thread;
  }
  
  public Timer getMonitorTimer() {
	  return monitorTimer;
  }
  
  public void initializePlayer2() {
    player2Thread = new Thread(player2, "Player" + player2.getPlayerID());
    add(player2, BorderLayout.LINE_END);
    player2.enablePlayer(false);
  }
  
  @Override
  public void startGame() {
    player1Thread.start();
    player2Thread.start();
    monitorTimer = new Timer("Monitor", true);
    TimerTask gameMonitor = new GameMonitor();
    monitorTimer.scheduleAtFixedRate(gameMonitor, 0, 50); 
  }
  
  
  private class GameMonitor extends TimerTask {
    @Override
    public void run() {
      // TODO Auto-generated method stub
      if (!player1.isRunning() || !player2.isRunning()) {
        if (!player1.isRunning()) {
          player2.enablePlayer(false);
          player2.setRunningState(false);
        } else {
          player1.enablePlayer(false);
          player1.setRunningState(false);
        }
        monitorTimer.cancel();
      }
    }
  }
  
}
