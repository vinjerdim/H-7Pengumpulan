/**
 * 
 */

package controller;

import java.awt.BorderLayout;

/**
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public class ComputerModeFrame extends FrameMode {
  private ComputerPlayer player2;
  
  public ComputerModeFrame() {
    super("Computer Versus Mode");
    
    player2 = new ComputerPlayer(puzzle);
    add(player1, BorderLayout.LINE_START);
    add(player2, BorderLayout.LINE_END);
    player1.enablePlayer(false);
    player2.enablePlayer(false);
    
    pack();
    setVisible(true);
    setResizable(false);
  }
  
  /* (non-Javadoc)
   * @see controller.FrameMode#startGame()
   */
  @Override
  public void startGame() {
    // TODO Auto-generated method stub

  }

}
