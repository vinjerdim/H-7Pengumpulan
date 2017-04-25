/**
 *
 */

package viewtest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import view.Tile;

/**
 * @author Martin Lutta Putra (13515121).
 *
 * 
 */
public class TileTest {

  @Test
  public void test() {
    Tile [] testTiles = new Tile[9];
    for (int i = 0; i < testTiles.length; i++) {
      testTiles[i] = new Tile(i, 9);
    }
    for (int i = 0; i < testTiles.length; i++) {
      assertTrue(testTiles[i].getTileValue() == i);
      assertTrue(testTiles[i].getDefaultSize() == 50);
    }
  }
}
