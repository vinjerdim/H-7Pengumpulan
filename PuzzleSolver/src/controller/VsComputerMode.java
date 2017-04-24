/**
 * 
 */

package controller;

import java.awt.BorderLayout;

/**
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public class VsComputerMode extends DualPlayerMode {

  /**
   * Konstruktor frame player versus computer.
   */
  public VsComputerMode() {
    // TODO Auto-generated constructor stub
    super();
    player2 = new ComputerPlayer(puzzle);
    add(player2, BorderLayout.LINE_END);
    player2.enablePlayer(false);
    
    pack();
    setVisible(true);
    setResizable(false);
  }
  
  @Override
  public void startGame() {
    player1.enablePlayer(true);
    player2.enablePlayer(false);
    super.startGame();
  }
}
