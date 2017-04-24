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
public class SinglePlayerMode extends FrameMode {
  /**
   * Konstruktor kelas SingleModeFrame.
   */
  public SinglePlayerMode() {
    super("Single Player Mode");
    add(player1, BorderLayout.PAGE_START);
    showFrame();
  }
  
  @Override
  public void startGame() {
    player1.enablePlayer(true);
    player1Thread.start();
    TimerTask gameMonitor = new GameMonitor();
    monitorTimer = new Timer(true);
    monitorTimer.scheduleAtFixedRate(gameMonitor, 0, 100);
  }
  
  private class GameMonitor extends TimerTask {
    @Override
    public void run() {
      // TODO Auto-generated method stub
      if (!player1Thread.isAlive()) {
        monitorTimer.cancel();
      }
    }
  }
}
