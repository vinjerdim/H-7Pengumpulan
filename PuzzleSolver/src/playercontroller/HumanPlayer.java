package playercontroller;

import java.util.Timer;
import java.util.TimerTask;

import model.Puzzle;

/**
 * Kelas HumanPlayer adalah kelas player untuk human
 * 
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public class HumanPlayer extends PlayerController {
  private static final long serialVersionUID = 1L;

  /** 
   * Konstruktor kelas HumanPlayer dengan parameter Puzzle.
   * @param p Puzzle yang akan diselesaikan
   */
  public HumanPlayer(Puzzle p) {
    super(p);
    movementLabel.setText("Movement(s): " + board.getMovementCount());
  }
 
  /**
   * Method untuk menjalankan HumanPlayer.
   */
  @Override
  public void run() {
    TimerTask showMovement = new ShowMovement();
    showTimer = new Timer("Timer" + playerId, true);
    showTimer.scheduleAtFixedRate(showMovement, 0, 10);
    super.run();
  }
  
  /**
   * Kelas ShowMovement yang memiliki parent TimerTask.
   */
  private class ShowMovement extends TimerTask {
    /**
     * Method untuk menjalankan ShowMovement.
     */
    @Override
    public void run() {
      // TODO Auto-generated method stub
      movementLabel.setText("Movement(s): " + board.getMovementCount());
    }
  }
}
