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
  
  public void initializePlayer2() {
    player2Thread = new Thread(player2);
    add(player2, BorderLayout.LINE_END);
    player2.enablePlayer(false);
  }
  
  @Override
  public void startGame() {
    player1Thread.start();
    player2Thread.start();
    monitorTimer = new Timer(true);
    TimerTask gameMonitor = new GameMonitor();
    monitorTimer.scheduleAtFixedRate(gameMonitor, 0, 100);
    
  }
  
  private class GameMonitor extends TimerTask {
    @Override
    public void run() {
      // TODO Auto-generated method stub
      if (!player1Thread.isAlive() || !player2Thread.isAlive()) {
        if (!player1Thread.isAlive()) {
          player2Thread.interrupt();
          player2.enablePlayer(false);
        } else {
          player1Thread.interrupt();
          player1.enablePlayer(false);
        }
        monitorTimer.cancel();
      }
    }
  }
  
}