package model;

/**
 * Kelas PuzzleSolver adalah kelas untuk menyelesaikan puzzle
 * 
 * @author Marvin Jerremy.
 *
 */
public class PuzzleSolver {
  private PuzzleNode current;
  private PuzzleNode solution = null;
  private int newBound;
  
  /**
   * Konstruktor kelas PuzzleSolver dengan satu parameter
   * @param c Puzzle
   */
  public PuzzleSolver(final Puzzle c) {
    current = new PuzzleNode(c);
  }
  
  /**
   * Method yang mengembalikan nilai current PuzzleNode
   * @return Current PuzzleNode
   */
  public PuzzleNode getCurrent() {
    return current;
  }
  
  /**
   * Method yang mengembalikan nilai PuzzleNode solution
   * @return PuzzleNode solution
   */
  public PuzzleNode getDeclarationSolution() {
    return solution;
  }

  /**
   * Method yang mengembalikan nilai Puzzlenode result
   * @return PuzzleNode result
   */
  public PuzzleNode getSolution() {
    int bound = current.getHeuristicCost();
    PuzzleNode result = null;
    while (result == null) {
      newBound = Integer.MAX_VALUE;
      result = search(current, bound);
      bound = newBound;
    }
    return result;
  }
  
  /**
   * Method search yang mengembalikan nilai PuzzleNode
   * @param currentNode PuzzleNode current
   * @param bound Integer bound
   * @return PuzzleNode solution
   */
  public PuzzleNode search(PuzzleNode currentNode, int bound) {
    for (PuzzleNode candidate : currentNode.getNeighbors()) {
      if (candidate.getCurrentPuzzle().isFinished()) {
        return candidate;
      }
      int currentCost = candidate.getCost();
      if (currentCost <= bound) {
        PuzzleNode tempSolution = search(candidate, bound);
        if (tempSolution != null && (solution == null 
            || tempSolution.getDepthCost() < solution.getDepthCost())) {
          solution = tempSolution;
        }
      } else {
        if (currentCost < newBound) {
          newBound = currentCost;
        }
      }
    }
    return solution;
  }
}
