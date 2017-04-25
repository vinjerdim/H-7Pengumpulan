package modecontroller;

import java.awt.BorderLayout;

import playercontroller.ComputerPlayer;

/**
 * Kelas VsComputerMode adalah kelas controller untuk mode versus computer 
 * 
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
    initializePlayer2();
  }
  
  /**
   * Method untuk memulai permainan mode versus computer
   */
  @Override
  public void startGame() {
    player1.enablePlayer(true);
    statusLabel.setText("Player 1 is active");
    super.startGame();
  }
}
