/**
 * 
 */

package controller;

import java.awt.BorderLayout;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JPanel;

import puzzle.Puzzle;
import views.PuzzleTile;
import views.Tile;

/**
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public class PlayerController extends JPanel implements Runnable {
  public static int playerCount = 0;
  protected PuzzleTile puzzleTile;
  protected Timer timer;
  protected JLabel movementLabel;
  private int playerId;
  
  
  public PlayerController(Puzzle p) {
    playerCount++;
    playerId = playerCount;
    puzzleTile = new PuzzleTile(p);
    movementLabel = new JLabel();
    
    setLayout(new BorderLayout());
    add(movementLabel, BorderLayout.PAGE_START);
    add(puzzleTile, BorderLayout.CENTER);
    
    setVisible(true);
  }
    
  public int getPlayerID() {
    return playerId;
  }
  
  public void enablePlayer(boolean enabled) {
    puzzleTile.setTilesEnabled(enabled);
  }
  
  @Override
  public void run() {
    // TODO Auto-generated method stub
    while (!puzzleTile.isFinished()) {
      
    }
    timer.cancel();
  }
}