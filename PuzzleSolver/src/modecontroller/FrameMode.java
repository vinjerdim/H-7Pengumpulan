package modecontroller;

import java.awt.BorderLayout;
import java.util.Timer;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Puzzle;
import playercontroller.HumanPlayer;

/**
 * Kelas FrameMode adalah Abstrak class untuk frame tampilan
 * 
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public abstract class FrameMode extends JPanel {
  private static final long serialVersionUID = 1L;
  protected HumanPlayer player1;
  protected Puzzle puzzle;
  protected Thread player1Thread;
  protected Timer monitorTimer;
  protected JLabel statusLabel;
  
  /**
   * Konstruktor kelas FrameMode dengan parameter frameName.
   */
  public FrameMode() {
    super();
    //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
    
    do {
      puzzle = new Puzzle((byte) 3);
    } while (puzzle.isFinished() || !puzzle.isSolvable());
        
    player1 = new HumanPlayer(puzzle);
    player1Thread = new Thread(player1, "Player" + + player1.getPlayerId());
    player1.enablePlayer(false);
    
    statusLabel = new JLabel("Ready to run");
    add(statusLabel, BorderLayout. PAGE_START);
  }
  
  /**
   * Method yang mengembalikan nilai puzzle.
   * @return Puzzle
   */
  public Puzzle getPuzzle() {
    return puzzle;
  }
  
  /**
   * Method yang mengembalikan nilai HumanPlayer.
   * @return Human player1
   */
  public HumanPlayer getPlayer1() {
    return player1;
  }
  
  /**
   * Method yang mengembalikan nilai Thread.
   * @return Thread player1
   */
  public Thread getPlayer1Thread() {
    return player1Thread;
  }
  
  /**
   * Method yang mengembalikan nilai monitor timer.
   * @return Monitor Timer
   */
  public Timer getMonitorTimer() {
    return monitorTimer;
  }
  
  /**
   * Abstrak method untuk start game.
   */
  public abstract void startGame();
  
  /**
   * Abstrak method untuk end game.
   */
  public abstract void endGame();
}
