/**
 * 
 */

package modecontroller;

import java.awt.BorderLayout;
import java.util.Timer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Puzzle;
import playercontroller.HumanPlayer;

/**
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public abstract class FrameMode extends JPanel {
  protected HumanPlayer player1;
  protected Puzzle puzzle;
  protected JButton jDependButton;
  protected Thread player1Thread;
  protected Timer monitorTimer;
  protected JLabel statusLabel;
  
  public FrameMode() {
    super();
    //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
    
    do {
      puzzle = new Puzzle((byte) 3);
    } while (puzzle.isFinished() || !puzzle.isSolvable());
        
    player1 = new HumanPlayer(puzzle);
    player1Thread = new Thread(player1, "Player" + + player1.getPlayerID());
    player1.enablePlayer(false);
    
    statusLabel = new JLabel("Ready to run");
    add(statusLabel, BorderLayout. PAGE_START);
  }
  
  public Puzzle getPuzzle() {
    return puzzle;
  }
  
  public HumanPlayer getPlayer1() {
    return player1;
  }
  
  public Thread getPlayer1Thread() {
    return player1Thread;
  }
  
  public Timer getMonitorTimer() {
    return monitorTimer;
  }
  
  public abstract void startGame();
  
  public abstract void endGame();
}
