/**
 * 
 */

package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import puzzle.Puzzle;
import views.PuzzleTile;

/**
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public class PlayerController extends JPanel implements KeyListener, Runnable {
  private static int playerCount = 0;
  private static int turn = 1;
  
  private int playerID;
  private JLabel movementLabel;
  private PuzzleTile puzzleTile;
  private JTextField inputField;
  private int movement = 0;
  
  public PlayerController(Puzzle p) {
    playerCount++;
    playerID = playerCount;
    movementLabel = new JLabel("Movement: " + movement);
    puzzleTile = new PuzzleTile(p);
    inputField = new JTextField();
    inputField.addKeyListener(this);
    setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
     
    add(movementLabel);
    add(puzzleTile);
    add(inputField);
     
    setVisible(true);
  }
  /* (non-Javadoc)
   * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
   */
  @Override
  public void keyPressed(KeyEvent e) {
    // TODO Auto-generated method stub
    int code = e.getKeyCode();
    setVisible(false);
    if (applyMove(code) != 0) {
      movement++;
      if (playerCount > 1) {
        turn %= playerCount;
        turn += 1;
      }
    }
    setVisible(true);
    movementLabel.setText("Movement: " + movement);
    
    if (puzzleTile.isFinished()) {
      inputField.setEnabled(false);
    } else {
      if (turn == playerID) {
        inputField.requestFocus();
      }
    }
    
  }
  
  /* (non-Javadoc)
   * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
   */
  @Override
  public void keyReleased(KeyEvent e) {
    // TODO Auto-generated method stub
    inputField.setText("");
  }

  /* (non-Javadoc)
   * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
   */
  @Override
  public void keyTyped(KeyEvent e) {
    // TODO Auto-generated method stub

  }
  
  @Override
  public void run() {
    // TODO Auto-generated method stub
    while (!puzzleTile.isFinished()) {
      
    }
  }
  
  public int applyMove(int code) {
    if (code == 37 && puzzleTile.isMovableTo(3)) {
      puzzleTile.moveTo(3);
      return 3;
    } else if (code == 38 && puzzleTile.isMovableTo(1)) {
      puzzleTile.moveTo(1);
      return 1;
    } else if (code == 39 && puzzleTile.isMovableTo(4)) {
      puzzleTile.moveTo(4);
      return 4;
    } else if (code == 40 && puzzleTile.isMovableTo(2)) {
      puzzleTile.moveTo(2);
      return 2;
    } else {
      return 0;
    }
  }
}
