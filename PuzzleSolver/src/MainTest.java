import controller.PuzzleController;

import java.awt.GridLayout;

import javax.swing.JFrame;

import puzzle.Puzzle;
import puzzle.PuzzleSolver;

public class MainTest {
  /**
   * Program utama.
   * @param args Argumen main program
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    JFrame frame = new JFrame("TopLevelDemo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new GridLayout(1,1));
    
    Puzzle p;
    do {
      p = new Puzzle((byte) (3));
    } while (!p.isSolvable() || p.isFinished());
    
    PuzzleController pc1 = new PuzzleController(p);
    PuzzleSolver ps = new PuzzleSolver(p);
    System.out.println(ps.getSolution());
    frame.add(pc1);
    
    frame.pack();
    frame.setVisible(true);
    frame.setResizable(false);
  }
}
