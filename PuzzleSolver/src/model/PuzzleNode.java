/**
 * PuzzleNode merupakan node yang akan diproses pada pencarian jalur
 */

package model;

import java.util.Vector;

/**
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
/**
 * @author
 *  Marvin Jerremy
 *
 */
/**
 * @author Marvin Jerremy
 *
 */
public class PuzzleNode {
  private Puzzle previous;
  private Puzzle current;
  private int heuristicCost;
  private int depthCost;
  private byte[] movement;
  
  /**
   * I.S. sembarang
   * F.S. PuzzleNode tercipta dengan elemen p beserta cost nya, path dialokasi
   * @param p menjadi elemen dari PuzzleNode
   */
  public PuzzleNode(final Puzzle c) {
    previous = null;
    current = new Puzzle(c);
    movement = new byte[0];
    heuristicCost = current.getManhattanCost();
    depthCost = movement.length;
  }
  
  public PuzzleNode(final Puzzle p, final Puzzle c, byte[] m) {
    previous = new Puzzle(p);
    current = new Puzzle(c);
    movement = new byte[m.length];
    for (int i = 0; i < m.length; i++) {
      movement[i] = m[i];
    }
    heuristicCost = current.getManhattanCost();
    depthCost = movement.length;
  }
  
  /**
   * I.S. sembarang
   * F.S. PuzzleNode tercipta dengan isi yang sama dengan parameter input
   * @param pn PuzzleNode yang ingin disalin
   */
  public PuzzleNode(final PuzzleNode pn) {
    previous = (pn.previous == null) ? null : new Puzzle(pn.previous);
    current = new Puzzle(pn.current);
    heuristicCost = pn.heuristicCost;
    depthCost = pn.heuristicCost;
    movement = new byte[pn.movement.length];
    for (int i = 0; i < movement.length; i++) {
      movement[i] = pn.movement[i];
    }
  }
  
  public Puzzle getPrevious() {
	  return previous;
  }
  
  public byte [] getMovement() {
	  return movement;
  }
  
  public Puzzle getCurrentPuzzle() {
    return current;
  }
  
  /**
   * I.S.
   * @return cost dari node
   */
  public int getCost() {
    return depthCost + heuristicCost;
  }
  
  public int getHeuristicCost() {
    return heuristicCost;
  }
  	
  public int getDepthCost() {
    return depthCost;
  }
  
  public byte[] getMovementSet() {
    return movement;
  }
  
  /**
   * I.S. PuzzleNode sudah tercipta
   * F.S. element movement bertambah satu
   * @param nextMove langkah yang akan ditambahkan
   */
  public void addMovement(int nextMove) {
    byte[] temp = new byte[movement.length + 1];
    for (int i = 0; i < movement.length; i++) {
      temp[i] = movement[i];
    }
    temp[temp.length - 1] = (byte) nextMove;
    movement = temp;
    depthCost++;
  }
  
  public Vector<PuzzleNode> getNeighbors() {
    Vector<PuzzleNode> result = new Vector<PuzzleNode>();
    Puzzle temp;
    PuzzleNode candidate;
    for (int i = 1; i <= 4; i++) {
      if (current.isMovableTo(i)) {
        temp = new Puzzle(current);
        temp.moveTo(i);
        if (!temp.equals(previous)) {
          candidate = new PuzzleNode(current, temp, movement);
          candidate.addMovement(i);
          result.add(candidate);
        }
      }
    }
    result.sort(new PuzzleNodeComparator());
    return result;
  }
  
  @Override
  public String toString() {
    String result = "";
    result += current.toString();
    result += (getCost() + "\n");
    for (int i = 0; i < movement.length; i++) {
      result += (movement[i] + " ");
    }
    result += "\n";
    return result;
  }
}
