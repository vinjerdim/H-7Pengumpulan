/**
 * 
 */

package controller;

import java.util.Timer;
import java.util.TimerTask;

import model.Puzzle;
import model.PuzzleSolver;

/**
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public class ComputerPlayer extends PlayerController {
  private byte[] solution;
  private byte movementIndex = 0;
  
  public byte[] getSolution() {
	  return solution;
  }
  public byte getMovementIndex() {
	  return movementIndex;
  }
  
  
  
  public ComputerPlayer(Puzzle p) {
    super(p);
    PuzzleSolver ps = new PuzzleSolver(p);
    solution = ps.getSolution().getMovementSet();
    movementLabel.setText(solution.length + " movements left");
  }
  
  @Override
  public void run() {
    TimerTask applyMovement = new ApplyMovement();
    showTimer = new Timer("Timer" + playerId, true);
    showTimer.scheduleAtFixedRate(applyMovement, 0, 1000);
    super.run();
  }
  
  private class ApplyMovement extends TimerTask {
    @Override
    public void run() {
      // TODO Auto-generated method stub
      board.moveTo(solution[movementIndex], false);
      movementIndex++;
      movementLabel.setText(solution.length - movementIndex + " movements left");
    }
  }
}
