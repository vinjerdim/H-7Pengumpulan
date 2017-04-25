package view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import modecontroller.FrameMode;

/**
 * Kelas ExitGame
 * 
 * @author Patrick Nugroho Hadiwinoto (13515040).
 *
 */
public class ExitGame implements MouseListener {
  private FrameMode gamePanel;
  private GameFrame gameFrame;
  
  /**
   * Konstruktor ExitGame dengan parameter FrameMode dan GameFrame.
   * @param f Framemode
   * @param g GameFrame
   */
  public ExitGame(FrameMode f, GameFrame g) {
    gamePanel = f;
    gameFrame = g;
  }
  
  /**
   * Method yang akan dijalankan jika exit diklik.
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
