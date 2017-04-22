import java.awt.BorderLayout;

import javax.swing.JFrame;

import puzzle.Puzzle;
import views.PuzzleTile;

public class MainTest {
  /**
   * Program utama.
   * @param args Argumen main program
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    JFrame frame = new JFrame("TopLevelDemo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());
    
    Puzzle p = new Puzzle((byte) (3));
    
    PuzzleTile puzzleTile = new PuzzleTile(p);
    
    System.out.println(p);
    frame.add(puzzleTile);
    puzzleTile.moveTo(1);;
    
    frame.pack();
    frame.setVisible(true);
    frame.setResizable(false);
  }
}
