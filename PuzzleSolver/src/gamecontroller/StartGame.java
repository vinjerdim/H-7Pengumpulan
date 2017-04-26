package gamecontroller;

import java.awt.event.MouseEvent;

import javax.swing.JButton;

import modecontroller.FrameMode;

/**
 * Kelas StartGame adalah view untuk memulai permainan.
 * @author Patrick Nugroho Hadiwinoto (13515040).
 */
public class StartGame extends ButtonAction {
  private JButton startButton;
  
  /**
   * Konstruktor kelas StartGame dengan dua parameter.
   * @param f Frame Game
   * @param b JButton
   */
  public StartGame(FrameMode f, JButton b) {
    super(f);
    startButton = b;
  }
  
  /**
   * Method yang akan dijalankan jika StartGame di click.
   */
  @Override
  public void mouseClicked(MouseEvent e) {
    // TODO Auto-generated method stub
    gamePanel.startGame();
    startButton.setEnabled(false);
    startButton.removeMouseListener(this);
  }
}
