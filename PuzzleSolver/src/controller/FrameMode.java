/**
 * 
 */

package controller;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import puzzle.Puzzle;

/**
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public abstract class FrameMode extends JFrame implements MouseListener {
  protected HumanPlayer player1;
  protected Puzzle puzzle;
  protected JButton startButton;
  protected Thread player1Thread;
  
  public FrameMode(String frameName) {
    super(frameName);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    
    do {
      puzzle = new Puzzle((byte) 3);
    } while (puzzle.isFinished() || !puzzle.isSolvable());
        
    player1 = new HumanPlayer(puzzle);
    player1Thread = new Thread(player1);
    
    startButton = new JButton("START");
    startButton.addMouseListener(this);
    add(startButton, BorderLayout.PAGE_END);
  }
  
  @Override
  public void mouseReleased(MouseEvent arg0) {
    // TODO Auto-generated method stub
  }
  
  @Override
  public void mousePressed(MouseEvent arg0) {
    // TODO Auto-generated method stub
  }
  
  @Override
  public void mouseExited(MouseEvent arg0) {
    // TODO Auto-generated method stub
  }
  
  @Override
  public void mouseEntered(MouseEvent arg0) {
    // TODO Auto-generated method stub
  }
  
  @Override
  public void mouseClicked(MouseEvent arg0) {
    // TODO Auto-generated method stub
    startGame();
    startButton.setEnabled(false);
    startButton.removeMouseListener(this);
  }
  
  public abstract void startGame();
}
