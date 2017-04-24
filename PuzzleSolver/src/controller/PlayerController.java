/**
 * 
 */

package controller;

import java.awt.BorderLayout;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Puzzle;
import views.Board;
import views.Tile;

/**
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public class PlayerController extends JPanel implements Runnable {
  public static int playerCount = 0;
  protected Board board;
  protected Timer showTimer;
  protected JLabel movementLabel;
  protected int playerId;
  private volatile boolean runningState = false;
  
  public PlayerController(Puzzle p) {
    playerCount++;
    playerId = playerCount;
    board = new Board(p);
    movementLabel = new JLabel();
    
    setLayout(new BorderLayout());
    add(movementLabel, BorderLayout.PAGE_START);
    add(board, BorderLayout.CENTER);
    
    setVisible(true);
  }
  
  public Board getBoard() {
    return board;
  }
  
  public Timer getShowTimer() {
    return showTimer;
  }
  
  public JLabel getMovementLabel() {
    return movementLabel;
  }
  
  public boolean getRunningState() {
    return runningState;
  }
  
  public int getPlayerID() {
    return playerId;
  }
  
  public void setRunningState(boolean state) {
    runningState = state;
  }
  
  public void enablePlayer(boolean enabled) {
    board.setTilesEnabled(enabled);
  }
  
  @Override
  public void run() {
    // TODO Auto-generated method stub
    setRunningState(true);
    while (!board.isFinished() && runningState) {
      
    }
    showTimer.cancel();
  }
}