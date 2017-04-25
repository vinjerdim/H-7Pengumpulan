package view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JRadioButton;

/**
 * Kelas SwitchToGame untuk memulai mengganti view ke Game
 * 
 * @author Muhamad Irfan Maulana (13515037).
 *
 */
public class SwitchToGame implements MouseListener {
  private MenuFrame menuFrame;
  private JRadioButton[] optionItem;
  
  /**
   * Konstruktor kelas SwitchToGame dengan dua parameter.
   * @param m MenuFrame
   * @param rb JRadioButton
   */
  public SwitchToGame(MenuFrame m, JRadioButton[] rb) {
    menuFrame = m;
    optionItem = rb;
  }
  
  /**
   * Method yang akan dijalankan jika SwitchToGame diklik.
   */
  @Override
  public void mouseClicked(MouseEvent arg0) {
    // TODO Auto-generated method stub
    if (optionItem[0].isSelected()) {
      new GameFrame("Single Player");
    } else if (optionItem[1].isSelected()) {
      new GameFrame("Player vs Player");
    } else if (optionItem[2].isSelected()) {
      new GameFrame("Player vs Computer");
    }
    menuFrame.dispose();
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
