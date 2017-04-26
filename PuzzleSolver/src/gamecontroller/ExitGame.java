package gamecontroller;

import java.awt.event.MouseEvent;

import modecontroller.FrameMode;

/**
 * Kelas ExitGame
 * @author Patrick Nugroho Hadiwinoto (13515040).
 *
 */
public class ExitGame extends ButtonAction {
  private GameFrame gameFrame;
  
  /**
   * Konstruktor ExitGame dengan parameter FrameMode dan GameFrame.
   * @param f Framemode
   * @param g GameFrame
   */
  public ExitGame(FrameMode f, GameFrame g) {
    super(f);
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
}
