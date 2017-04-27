package modecontroller;

import java.util.Timer;
import java.util.TimerTask;

import playercontroller.HumanPlayer;

/**
 * Kelas VsPlayerMode adalah kelas controller untuk mode versus player
 * 
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public class VsPlayerMode extends DualPlayerMode {
  private static final long serialVersionUID = 1L;
  private static int turn;
  private Timer switchingTimer;
  
  /**
   * Konstruktor untuk frame player versus player.
   * @param delay Delay untuk multiplayer
   */
  public VsPlayerMode(int delay) {
    // TODO Auto-generated constructor stub
    super(delay);
    player2 = new HumanPlayer(puzzle);
    switchingTimer = new Timer("Switcher", true);
    initializePlayer2();
  }
  
  /**
   * Method yang mengembalikan turn.
   * @return Nilai turn
   */
  public int getTurn() {
    return turn;
  }
  
  /**
   * Method yang mengembalikan nilai switching timer.
   * @return Switching timer
   */
  public Timer getSwitchingTimer() {
    return switchingTimer;
  }
  
  /**
   * Method untuk memulai permainan mode versus player.
   */
  @Override
  public void startGame() {
    turn = 1;
    super.startGame();
    TimerTask switchTurn = new SwitchTurn();
    switchingTimer.scheduleAtFixedRate(switchTurn, 0, delayTime * 1000);
  }
  
  @Override
  public void endGame() {
    super.endGame();
    switchingTimer.cancel();
  }
  
  /**
   * Kelas SwitchTurn adalah kelas yang mempunyai parent TimerTask.
   */
  private class SwitchTurn extends TimerTask {
    /**
     * Method untuk menjalankan SwitchTurn.
     */
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
      }
    }
  }
}
