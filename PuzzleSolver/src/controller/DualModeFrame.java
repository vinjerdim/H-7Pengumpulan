/**
 * 
 */

package controller;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import puzzle.Puzzle;
import puzzle.PuzzleSolver;

/**
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public class DualModeFrame extends JFrame {
  /**
   * Konstruktor kelas SingleModeFrame.
   */
  public DualModeFrame() {
    super("Dual Player Mode");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout(1, 1));
    
    Puzzle p;
    do {
      p = new Puzzle((byte) 3);
    } while (p.isFinished() || !p.isSolvable());
    
    PuzzleSolver ps = new PuzzleSolver(p);
    System.out.println(ps.getSolution());
    
    PlayerController pc1 = new PlayerController(p);
    PlayerController pc2 = new PlayerController(p);
    
    add(pc1, BorderLayout.LINE_START);
    add(pc2, BorderLayout.LINE_END);
    
    pack();
    setVisible(true);
    setResizable(false);
    
    Thread t1 = new Thread(pc1);
    Thread t2 = new Thread(pc2);
    t1.start();
    t2.start();
    while (t1.isAlive() && t2.isAlive()) {
      
    }
  }
}
