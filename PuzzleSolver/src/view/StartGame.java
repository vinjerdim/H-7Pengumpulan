package view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import modecontroller.FrameMode;

/**
 * Kelas StartGame adalah view untuk memulai permainan
 * 
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public class StartGame implements MouseListener {
  private FrameMode gamePanel;
  private JButton startButton;
  
  /**
   * Konstruktor kelas StartGame dengan dua parameter
   * @param g FrameMode
   * @param b JButton
   */
  public StartGame(FrameMode g, JButton b) {
    gamePanel = g;
    startButton = b;
  }
  
  /**
   * Method yang akan dijalankan jika StartGame di click
   */
  @Override
  public void mouseClicked(MouseEvent e) {
    // TODO Auto-generated method stub
    gamePanel.startGame();
    startButton.setEnabled(false);
    startButton.removeMouseListener(this);
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
