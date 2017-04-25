package playercontroller;

import java.awt.BorderLayout;
import java.util.Timer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Puzzle;
import view.Board;

/**
 * Kelas PlayerController adalah kelas controller untuk suatu player
 * 
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public class PlayerController extends JPanel implements Runnable {
  public static int playerCount = 0;
  protected Board board;
  protected Timer showTimer;
  protected JLabel movementLabel;
  protected int playerId;
  private volatile boolean runningState;
  
  /**
   * Konstruktor kelas PlayerController dengan parameter Puzzle
   * 
   * @param p Puzzle yang akan di control oleh player
   */
  public PlayerController(Puzzle p) {
    playerCount++;
    playerId = playerCount;
    board = new Board(p);
    movementLabel = new JLabel();
    setRunningState(true);
    
    setLayout(new BorderLayout());
    add(movementLabel, BorderLayout.PAGE_START);
    add(board, BorderLayout.CENTER);
    
    setVisible(true);
  }
  
  /**
   * Method yang mengembalikan board
   * @return Board player
   */
  public Board getBoard() {
    return board;
  }
  
  /**
   * Method yang mengembalian timer player
   * @return Timer player
   */
  public Timer getShowTimer() {
    return showTimer;
  }
  
  /**
   * Method yang mengembalikan nilai movement label
   * @return Movement label
   */
  public JLabel getMovementLabel() {
    return movementLabel;
  }
  
  /**
   * Method yang menembalikan player id
   * 
   * @return Nilai player id
   */
  public int getPlayerID() {
    return playerId;
  }
  
  /**
   * Method yang mengecek state
   * @return True jika state sedang running
   */
  public boolean isRunning() {
    return runningState;
  }
  
  /**
   * Method untuk meng-set state;
   * @param state
   */
  public void setRunningState(boolean state) {
    runningState = state;
  }
  
  /**
   * Method untuk men-set status player
   * 
   * @param enabled Boolean yang akan diset ke player
   */
  public void enablePlayer(boolean enabled) {
    board.setTilesEnabled(enabled);
  }
  
  /**
   * Method untuk menjalankan PlayerController
   */
  @Override
  public void run() {
    // TODO Auto-generated method stub
    while (isRunning()) {
      if (board.isFinished()) {
        setRunningState(false);
      }
    }
    showTimer.cancel();
  }
}