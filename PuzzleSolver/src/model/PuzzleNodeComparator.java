package model;

import java.util.Comparator;

/**
 * Kelas PuzzleNodeComparator adalah kelas untuk membandingkan puzzle node
 * 
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public class PuzzleNodeComparator implements Comparator<PuzzleNode> {
  /**
   * Method untuk membandingkan dua PuzzleNode.
   * @param pn1 PuzzleNode 1
   * @param pn2 PuzzleNode 2
   * @return bernilai 1 jika getcost1 > getcost2 , 
   *         bernilai -1 jika getcost1 < getcost2, bernilai 0 jika selain itu
   */
  @Override
  public int compare(PuzzleNode pn1, PuzzleNode pn2) {
    if (pn1.getCost() < pn2.getCost()) {
      return -1;
    } else if (pn1.getCost() > pn2.getCost()) {
      return 1;
    }
    return 0;
  }
}
