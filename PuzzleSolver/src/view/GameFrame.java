package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import modecontroller.FrameMode;
import modecontroller.SinglePlayerMode;
import modecontroller.VsComputerMode;
import modecontroller.VsPlayerMode;

/**
 * Kelas GameFrame untuk view Game
 * 
 * @author Muhamad Irfan Maulana (13515037).
 *
 */
public class GameFrame extends JFrame {
  private static final long serialVersionUID = 1L;
  private FrameMode gamePanel;
  protected JButton startButton;
  protected JButton exitButton;
  protected JPanel buttonPanel;
  
  /**
   * Konstruktor kelas GameFrame dengan parameter frameTitle.
   * 
   * @param frameTitle Nama frame
   */
  public GameFrame(String frameTitle) {
    super(frameTitle);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    gamePanel = null;
    
    buttonPanel = new JPanel();
    buttonPanel.setLayout(new BorderLayout());
    startButton = new JButton("START");
    exitButton = new JButton("EXIT");
    buttonPanel.add(startButton, BorderLayout.LINE_START);
    buttonPanel.add(exitButton, BorderLayout.LINE_END);
    
    if (frameTitle.equals("Single Player")) {
      gamePanel = new SinglePlayerMode();
    } else if (frameTitle.equals("Player vs Player")) {
      gamePanel = new VsPlayerMode();
    } else if (frameTitle.equals("Player vs Computer")) {
      gamePanel = new VsComputerMode();
    }
    if (gamePanel != null) {
      startButton.addMouseListener(new StartGame(gamePanel, startButton));
      exitButton.addMouseListener(new ExitGame(gamePanel, this));
      add(gamePanel, BorderLayout.CENTER);
    }
    
    add(buttonPanel, BorderLayout.PAGE_END);
    
    pack();
    setResizable(false);
    setVisible(true);
  }
}
