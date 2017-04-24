/**
 * 
 */

package model;

/**
 * @author Marvin Jerremy.
 *
 */

public class PuzzleSolver {
  private PuzzleNode current;
  private PuzzleNode solution = null;
  private int newBound;
  
  public PuzzleSolver(final Puzzle c) {
    current = new PuzzleNode(c);
  }
  
  public PuzzleNode getCurrent() {
	  return current;
  }
  public PuzzleNode getDeclarationSolution() {
	  return solution;
  }

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
  
  public PuzzleNode search(PuzzleNode currentNode, int bound) {
    for (PuzzleNode candidate : currentNode.getNeighbors()) {
      if (candidate.getCurrentPuzzle().isFinished()) {
        return candidate;
      }
      int currentCost = candidate.getCost();
      if (currentCost <= bound) {
        PuzzleNode tempSolution = search(candidate, bound);
        if (tempSolution != null && (solution == null || tempSolution.getDepthCost() < solution.getDepthCost())) {
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
