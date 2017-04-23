package views;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 
 */

/**
 * @author Marvin Jerremy
 *
 */
public class SampleListener implements KeyListener {
  private PuzzleTile puzzleTile;
  
  
  public SampleListener(PuzzleTile pt) {
    puzzleTile = pt;
  }
  /* (non-Javadoc)
   * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
   */
  @Override
  public void keyPressed(KeyEvent event) {
    // TODO Auto-generated method stub
    int keyCode = event.getKeyCode();
    System.out.println(keyCode + "");
    switch (keyCode) {
      case 37 :
        if (puzzleTile.isMovableTo(3)) {
          puzzleTile.moveTo(3);
        }
        break;
      case 38 :
        if (puzzleTile.isMovableTo(1)) {
          puzzleTile.moveTo(1);
        }
        break;
      case 39 :
        if (puzzleTile.isMovableTo(4)) {
          puzzleTile.moveTo(4);
        }
        break;
      case 40 :
        if (puzzleTile.isMovableTo(2)) {
          puzzleTile.moveTo(2);
        }
        break;
      default:
        break;
    }
  }

  /* (non-Javadoc)
   * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
   */
  @Override
  public void keyReleased(KeyEvent arg0) {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
   */
  @Override
  public void keyTyped(KeyEvent arg0) {
    // TODO Auto-generated method stub

  }

}
