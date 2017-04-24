/**
 *
 */
package viewtest;

import static org.junit.Assert.*;
import views.Tile;

import org.junit.Test;

/**
 * @author Martin Lutta Putra (13515121).
 *
 * 
 */
public class TileTest {

	@Test
	public void test() {
		Tile [] TestTiles = new Tile[9];
		for (int i = 0; i < TestTiles.length; i++) {
			TestTiles[i] = new Tile(i, 9);
		}
		for (int i = 0; i < TestTiles.length; i++) {
			assertTrue(TestTiles[i].getTileValue() == i);
			assertTrue(TestTiles[i].getDefaultSize() == 50);
		}
	}
}
