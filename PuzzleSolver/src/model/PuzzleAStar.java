/**
 * PuzzleSolver bertugas mencari solusi dari suatu puzzle.
 */

package model;

import java.util.Vector;

/**
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public class PuzzleAStar {
  private Vector<PuzzleNode> nodeQueue = new Vector<PuzzleNode>();
  
  public PuzzleAStar(final Puzzle p) {
    PuzzleNode current = new PuzzleNode(p);
    nodeQueue.add(current);
  }
  
  public PuzzleNode getSolution() {
    PuzzleNode currentNode = nodeQueue.firstElement();
    nodeQueue.remove(0);
    while (!currentNode.getCurrentPuzzle().isFinished()) {
      for (PuzzleNode candidate : currentNode.getNeighbors()) {
        nodeQueue.add(candidate);
      }
      nodeQueue.sort(new PuzzleNodeComparator());
      currentNode = nodeQueue.firstElement();
      nodeQueue.remove(0);
    }
    return currentNode;
  }
}
