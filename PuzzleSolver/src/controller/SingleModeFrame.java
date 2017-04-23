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
public class SingleModeFrame extends JFrame {
  /**
   * Konstruktor kelas SingleModeFrame.
   */
  public SingleModeFrame() {
    super("Single Player Mode");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout(1, 1));
    
    Puzzle p;
    do {
      p = new Puzzle((byte) 3);
    } while (p.isFinished() || !p.isSolvable());
    
    PuzzleSolver ps = new PuzzleSolver(p);
    System.out.println(ps.getSolution());
    
    PlayerController pc = new PlayerController(p);
    
    add(pc, BorderLayout.PAGE_START);
    
    pack();
    setVisible(true);
    setResizable(false);
    
    Thread t1 = new Thread(pc);
    t1.start();
    while (t1.isAlive()) {
      
    }
  }
}
