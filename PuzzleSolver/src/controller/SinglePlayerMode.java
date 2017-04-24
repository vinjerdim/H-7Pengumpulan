/**
 * 
 */

package controller;

import java.awt.BorderLayout;

/**
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public class SinglePlayerMode extends FrameMode {
  /**
   * Konstruktor kelas SingleModeFrame.
   */
  public SinglePlayerMode() {
    super("Single Player Mode");
    
    add(player1, BorderLayout.PAGE_START);
    player1.enablePlayer(false);
    
    pack();
    setVisible(true);
    setResizable(false);
  }
  
  @Override
  public void startGame() {
    player1.enablePlayer(true);
    player1Thread.start();
    try {
      player1Thread.join();
    } catch (InterruptedException ie) {
      System.out.println("Player 1 interrupted");
    }
  }
}
