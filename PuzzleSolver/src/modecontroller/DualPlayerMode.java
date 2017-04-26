package modecontroller;

import java.awt.BorderLayout;
import java.util.Timer;
import java.util.TimerTask;

import playercontroller.PlayerController;

/**
 * Kelas DualPlayerMode adalah kelas controller untuk mode dual player
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public class DualPlayerMode extends FrameMode {
  private static final long serialVersionUID = 1L;
  protected PlayerController player2;
  protected Thread player2Thread;
  protected int delayTime;
  
  /**
   * Konstruktor frame dual player.
   */
  public DualPlayerMode(int delay) {
    super();
    delayTime = delay;
    add(player1, BorderLayout.LINE_START);
  }
  
  /**
   * Method yang mengembalikan player2.
   * @return PlayerController player2
   */
  public PlayerController getPlayer2() {
    return player2;
  }
  
  /**
   * Method yang mengembalikan player2 thread.
   * @return Player 2 thread
   */
  public Thread getPlayer2Thread() {
    return player2Thread;
  }
  
  /**
   * Method yang mengembalikan timer monitor.
   * @return Timer monitor
   */
  public Timer getMonitorTimer() {
    return monitorTimer;
  }
  
  /**
   * Method untuk menginisialisasi player2.
   */
  public void initializePlayer2() {
    player2Thread = new Thread(player2, "Player" + player2.getPlayerId());
    add(player2, BorderLayout.LINE_END);
    player2.enablePlayer(false);
  }
  
  /**
   * Method untuk memulai permainan mode dual player.
   */
  @Override
  public void startGame() {
    TimerTask gameMonitor = new GameMonitor();
    monitorTimer.scheduleAtFixedRate(gameMonitor, 0, 100); 
    player1Thread.start();
    player2Thread.start();
  }
  
  /**
   * Method untuk membuat game selesai.
   */
  @Override
  public void endGame() {
    // TODO Auto-generated method stub
    player1.setRunningState(false);
    player2.setRunningState(false);
    monitorTimer.cancel();
  }
  
  /**
   * Kelas GameMonitor yang mempunyai parent TimerTask.
   */
  private class GameMonitor extends TimerTask {
    /**
     * Method untuk menjalankan GameMonitor.
     */
    @Override
    public void run() {
      // TODO Auto-generated method stub
      if (!player1.isRunning() || !player2.isRunning()) {
        if (!player1.isRunning()) {
          statusLabel.setText("Player 1 finished the puzzle");
          player2.enablePlayer(false);
          player2.setRunningState(false);
        } else {
          statusLabel.setText("Player 2 finished the puzzle");
          player1.enablePlayer(false);
          player1.setRunningState(false);
        }
        monitorTimer.cancel();
      }
    }
  }
}
