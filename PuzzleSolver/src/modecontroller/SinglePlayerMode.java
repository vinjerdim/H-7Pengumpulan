package modecontroller;

import java.awt.BorderLayout;
import java.util.TimerTask;

/**
 * Kelas SinglePlayerMode adalah kelas controller untuk mode single player
 * 
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public class SinglePlayerMode extends FrameMode {
  private static final long serialVersionUID = 1L;

  /**
   * Konstruktor kelas SingleModeFrame.
   */
  public SinglePlayerMode() {
    super();
    add(player1, BorderLayout.CENTER);
  }
  
  /**
   * Method untuk memulai permainan mode single player.
   */
  @Override
  public void startGame() {
    player1.enablePlayer(true);
    player1Thread.start();
    TimerTask gameMonitor = new GameMonitor();
    monitorTimer.scheduleAtFixedRate(gameMonitor, 0, 100);
  }
  
  /**
   * Kelas GameMonitor adalah kelas yang mempunyai parent TimerTask.
   */
  private class GameMonitor extends TimerTask {
    /**
     * Method untuk menjalankan GameMonitor.
     */
    @Override
    public void run() {
      // TODO Auto-generated method stub
      statusLabel.setText("Player 1 is active");
      if (!player1.isRunning()) {
        monitorTimer.cancel();
        statusLabel.setText("Player 1 finished the puzzle");
      }
    }
  }

  /**
   * Method yang akan dijalankan jika game selesai.
   */
  @Override
  public void endGame() {
    // TODO Auto-generated method stub
    player1.setRunningState(false);
  }
}
