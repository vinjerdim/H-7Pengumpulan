package playercontroller;

import java.util.Timer;
import java.util.TimerTask;

import model.Puzzle;
import model.PuzzleSolver;

/**
 * Kelas ComputerPlayer adalah kelas player untuk computer
 * 
 * @author Marvin Jerremy Budiman (13515076).
 */
public class ComputerPlayer extends PlayerController {
  private byte[] solution;
  private byte movementIndex = 0;
   
  /**
   * Konstruktor kelas ComputerPlayer dengan parameter Puzzle
   * 
   * @param p Puzzle computer
   */
  public ComputerPlayer(Puzzle p) {
    super(p);
    PuzzleSolver ps = new PuzzleSolver(p);
    solution = ps.getSolution().getMovementSet();
    movementLabel.setText(solution.length + " movement(s) left");
  }
  
  /**
   * Method yang mengembalikan nilai solution
   * @return solution
   */
  public byte[] getSolution() {
	    return solution;
  }
  
  /**
   * Method yang mengembalikan nilai index movement
   * @return Index movement
   */
  public byte getMovementIndex() {
    return movementIndex;
  }
  
  /**
   * Method untuk menjalankan ComputerPlayer
   */
  @Override
  public void run() {
    TimerTask applyMovement = new ApplyMovement();
    showTimer = new Timer("Timer" + playerId, true);
    showTimer.scheduleAtFixedRate(applyMovement, 0, 1000);
    super.run();
  }
  
  /**
   * Kelas ApplyMovement yang mempunyai parent TImerTask
   * 
   * @author 
   *
   */
  private class ApplyMovement extends TimerTask {
  /**
	* Method run untuk menjalankan ApplyMovement
	*/
	@Override
    public void run() {
      // TODO Auto-generated method stub
      board.moveTo(solution[movementIndex], false);
      movementIndex++;
      movementLabel.setText(solution.length - movementIndex + " movement(s) left");
    }
  }
}
