package gamecontroller;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import modecontroller.FrameMode;
import modecontroller.SinglePlayerMode;
import modecontroller.VsComputerMode;
import modecontroller.VsPlayerMode;

/**
 * Kelas GameFrame untuk view Game
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
   * @param frameTitle Nama frame
   * @param delay Delay untuk multiplayer
   */
  public GameFrame(String frameTitle, int delay) {
    super(frameTitle);
    setLayout(new BorderLayout());
    setLocation(150, 150);  
    
    gamePanel = null;
    startButton = new JButton("START");
    exitButton = new JButton("EXIT");
    
    buttonPanel = new JPanel();
    buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
    buttonPanel.add(startButton);
    buttonPanel.add(exitButton);
    
    if (frameTitle.equals("Single Player")) {
      gamePanel = new SinglePlayerMode();
    } else if (frameTitle.equals("Player vs Player")) {
      gamePanel = new VsPlayerMode(delay);
    } else if (frameTitle.equals("Player vs Computer")) {
      gamePanel = new VsComputerMode(delay);
    }
    if (gamePanel != null) {
      startButton.addMouseListener(new StartGame(gamePanel, startButton));
      exitButton.addMouseListener(new ExitGame(gamePanel, this));
      
      JPanel panel = new JPanel();
      panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
      panel.add(gamePanel);
      panel.add(buttonPanel);
      add(panel, BorderLayout.CENTER);
      
      addWindowListener(new SwitchToMenu(gamePanel, this));
    }
    
    pack();
    setResizable(false);
    setVisible(true);
  }
  
  private class SwitchToMenu implements WindowListener {
    private GameFrame gameFrame;
    private FrameMode gamePanel;
    
    public SwitchToMenu(FrameMode f, GameFrame g) {
      gamePanel = f;
      gameFrame = g;
    }
    
    @Override
    public void windowActivated(WindowEvent e) {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void windowClosed(WindowEvent e) {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void windowClosing(WindowEvent e) {
      // TODO Auto-generated method stub
      gamePanel.endGame();
      gameFrame.dispose();
      new MenuFrame();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void windowIconified(WindowEvent e) {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void windowOpened(WindowEvent e) {
      // TODO Auto-generated method stub
      
    }
    
  }
}
