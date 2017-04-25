/**
 * 
 */

package view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import modecontroller.FrameMode;

/**
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public class ExitGame implements MouseListener {
  private FrameMode gamePanel;
  private GameFrame gameFrame;
  
  public ExitGame(FrameMode f, GameFrame g) {
    gamePanel = f;
    gameFrame = g;
  }
  
  /* (non-Javadoc)
   * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
   */
  @Override
  public void mouseClicked(MouseEvent e) {
    // TODO Auto-generated method stub
    gamePanel.endGame();
    gameFrame.dispose();
    new MenuFrame();
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

}
