package modecontroller;

import playercontroller.ComputerPlayer;

/**
 * Kelas VsComputerMode adalah kelas controller untuk mode versus computer 
 * 
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public class VsComputerMode extends DualPlayerMode {
  private static final long serialVersionUID = 1L;

  /**
   * Konstruktor frame player versus computer.
   * @param delay Delay untuk multiplayer
   */
  public VsComputerMode(int delay) {
    // TODO Auto-generated constructor stub
    super(delay);
    player2 = new ComputerPlayer(puzzle, delay);
    initializePlayer2();
  }
  
  /**
   * Method untuk memulai permainan mode versus computer.
   */
  @Override
  public void startGame() {
    player1.enablePlayer(true);
    statusLabel.setText("Player 1 is active");
    super.startGame();
  }
}
