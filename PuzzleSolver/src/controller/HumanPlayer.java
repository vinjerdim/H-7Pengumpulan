/**
 * 
 */

package controller;

import java.util.Timer;
import java.util.TimerTask;

import puzzle.Puzzle;

/**
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public class HumanPlayer extends PlayerController {
  /**
   * 
   * @param p Puzzle yang akan diselesaikan.
   */
  public HumanPlayer(Puzzle p) {
    super(p);
    movementLabel.setText("Movement: " + puzzleTile.getMovementCount());
  }
 
  @Override
  public void run() {
    TimerTask showMovement = new ShowMovement();
    timer = new Timer(true);
    timer.scheduleAtFixedRate(showMovement, 0, 100);
    super.run();
  }
  
  private class ShowMovement extends TimerTask {
    @Override
    public void run() {
      // TODO Auto-generated method stub
      movementLabel.setText("Movement: " + puzzleTile.getMovementCount());
    }
  }
}
