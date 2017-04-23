/**
 * 
 */

package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

import puzzle.Puzzle;
import views.PuzzleTile;

/**
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public class PuzzleController extends JPanel implements KeyListener {
  private PuzzleTile puzzleTile;
  private JTextField inputField;
  
  public PuzzleController(Puzzle p) {
     puzzleTile = new PuzzleTile(p);
     inputField = new JTextField();
     inputField.addKeyListener(this);
     setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
     
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
    if (code == 37 && puzzleTile.isMovableTo(3)) {
      puzzleTile.moveTo(3);
    } else if (code == 38 && puzzleTile.isMovableTo(1)) {
      puzzleTile.moveTo(1);
    } else if (code == 39 && puzzleTile.isMovableTo(4)) {
      puzzleTile.moveTo(4);
    } else if (code == 40 && puzzleTile.isMovableTo(2)) {
      puzzleTile.moveTo(2);
    }
    setVisible(true);
    if (puzzleTile.isFinished()) {
      inputField.setEnabled(false);
    } else {
      inputField.requestFocus();
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

}
