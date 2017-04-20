/**
 * Main merupakan program utama.
 */

import puzzle.Puzzle;

import puzzle.PuzzleSolver;

/**
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public class Main {
  /**
   * Program utama.
   * @param args Argumen main program
   */
  public static void main(String[] args) {
    
    Puzzle p1;
    do {
      p1 = new Puzzle((byte)4); 
    } while (p1.isFinished() || !p1.isSolvable());
    System.out.println(p1);
    System.out.println("Please wait ...");
    long start;
    long end;
    /**
    PuzzleSolver solver1 = new PuzzleSolver(p1);
    start = System.currentTimeMillis();
    System.out.println(solver1.getSolution());
    end = System.currentTimeMillis();
    System.out.println((end - start) / 1000 + " seconds elapsed");
    System.out.println("");
    */
    PuzzleSolver solver2 = new PuzzleSolver(p1);
    start = System.currentTimeMillis();
    System.out.println(solver2.getSolution());
    end = System.currentTimeMillis();
    System.out.println((end - start) / 1000 + " seconds elapsed");
    
  }
}