package view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Kelas SwitcToMenu adalah kelas untuk memindahkan view dari game ke menu
 * 
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public class SwitchToMenu implements MouseListener {
  private GameFrame gameFrame;
  
  /**
   * Konstruktor kelas SwitchToMenu dengan satu parameter
   * 
   * @param g GameFrame
   */
  public SwitchToMenu(GameFrame g) {
    gameFrame = g;
  }
  
  /**
   * Method yang akan dijalankan jika SwitchToMenu di Click
   */
  @Override
  public void mouseClicked(MouseEvent arg0) {
    // TODO Auto-generated method stub
    new MenuFrame();
    gameFrame.dispose();
  }

  /* (non-Javadoc)
   * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
   */
  @Override
  public void mouseEntered(MouseEvent arg0) {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
   */
  @Override
  public void mouseExited(MouseEvent arg0) {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
   */
  @Override
  public void mousePressed(MouseEvent arg0) {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
   */
  @Override
  public void mouseReleased(MouseEvent arg0) {
    // TODO Auto-generated method stub

  }

}
