package gamecontroller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import modecontroller.FrameMode;

/**
 * Kelas abstrak yang menangani aksi button start dan exit
 * @author Marvin Jerremy Budiman (1351506).
 */
public abstract class ButtonAction implements MouseListener {
  protected FrameMode gamePanel;
  
  /**
   * Konstruktor ButtonAction.
   * @param f Frame Game
   */
  public ButtonAction(FrameMode f) {
    gamePanel = f;
  }
  
  /* (non-Javadoc)
   * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
   */
  @Override
  public void mouseEntered(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
   */
  @Override
  public void mouseExited(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
   */
  @Override
  public void mousePressed(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
   */
  @Override
  public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub

  }
  
  public abstract void mouseClicked(MouseEvent arg0);
}
