/**
 * Puzzle menangani pembentukan puzzle dan perubahan state puzzle
 */

package model;

import java.util.Random;

/**
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public class Puzzle {
  protected byte[] tiles;
  protected byte size;
  protected byte maxValue;
  protected byte blankLocation;
  
  /**
   * I.S. sembarang
   * F.S. tercipta Puzzle dengan ukuran tertentu dan susunan acak
   * @param size Ukuran Puzzle
   */
  public Puzzle(byte size) {
    this.size = size;
    maxValue = (byte) (size * size);
    tiles = new byte[maxValue];
    for (int i = 0; i < tiles.length; i++) {
      tiles[i] = 0;
    }
    
    Random rand = new Random();
    for (int i = 1; i <= maxValue; i++) {
      byte candidate;
      do {
        candidate = (byte) rand.nextInt(maxValue);
      } while (tiles[candidate] != 0);
      tiles[candidate] = (byte) i;
      if (i == maxValue) {
        blankLocation = candidate;
      }
    }
  }
  
  /**
   * I.S. sembarang
   * F.S. tercipta puzzle dengan ukuran dan susunan sama dengan suatu puzzle lain
   * @param p Puzzle yang ingin diduplikasi
   */
  public Puzzle(final Puzzle p) {
    size = p.size;
    maxValue = p.maxValue;
    blankLocation = p.blankLocation;
    tiles = new byte[maxValue];
    for (int i = 0; i < maxValue; i++) {
      tiles[i] = p.tiles[i];
    }
  }
  
  public byte getSize() {
    return size;
  }
  
  public byte getValue(int index) {
    return tiles[index];
  }
  
  public byte getMaxValue() {
    return maxValue;
  }
   
  /**
   * 
   * @param value Nilai yang akan dicari pada array tiles
   * @return index letak nilai yang dicari, -1 jika tidak ditemukan.
   */
  public int getTileIndex(int value) {
    int result = -1;
    int i = 0;
    while (i < maxValue && result == -1) {
      if (tiles[i] == value) {
        result = i;
      } else {
        i++;
      }
    }
    return result;
  }
  
  @Override
  public String toString() {
    String result = "";
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (j != 0) {
          result += " ";
        }
        if (tiles[size * i + j] / 10 == 0) {
          result += " ";
        }
        result += tiles[size * i + j];
      }
      result += "\n";
    }
    result += (blankLocation + "\n");
    result += (maxValue + "\n");
    result += (size + "\n");
    return result;
  }
  
  /**
   * I.S. Puzzle sudah terbentuk
   * F.S. sama dengan I.S., mengembalikan total jarak Manhattan setiap tile ke tujuannya
   * @return total jarak Manhattan dari setiap tile ke tujuannya
   */
  public int getManhattanCost() {
    int cost = 0;
    for (int i = 1; i < maxValue; i++) {
      int source = getTileIndex(i);
      int destination = i - 1;
      int temp = 0;
      temp += Math.abs(source / size - destination / size);
      temp += Math.abs(source % size - destination % size);
      cost += temp;
    }
    return cost;
  }
  
  /**
   * 
   * @return Mengembalikan jumlah tile yang melebihi posisi seharusnya.
   */
  public int getInversions() {
    int result = 0;
    for (int i = 0; i < maxValue; i++) {
      int temp = 0;
      int currentValue = tiles[i];
      if (currentValue != maxValue) {
        for (int j = i + 1; j < maxValue; j++) {
          if (tiles[j] < currentValue) {
            temp++;
          }
        }
      }
      result += temp;
    }
    return result;
  }

  /**
   * I.S. Puzzle sudah terbentuk
   * F.S. sama dengan I.S., mengembalikan nilai true jika puzzle solvable
   * @return true jika puzzle bisa diselesaikan.
   */
  public boolean isSolvable() {
    int inversions = getInversions();
    if (size % 2 != 0) {
      return (inversions % 2 == 0);
    } else {
      return ((inversions + blankLocation / size) % 2 != 0);
    }
  }
  
  /**
   * I.S. Puzzle sudah terbentuk
   * F.S. sama dengan I.S.
   * @return true jika susunan puzzle sudah benar 
   */
  public boolean isFinished() {
    return getManhattanCost() == 0; 
  }
  
  /**
   * 
   * @param direction Arah pergerakan petak kosong (1: atas, 2: bawah, 3: kiri, 4: kanan).
   * @return true jika petak kosong dapat bergerak ke arah tersebut
   */
  public boolean isMovableTo(int direction) {
    if (direction == 1 || direction == 2) {
      int row = blankLocation / size;
      return ((direction == 1) ? row != 0 : row != size - 1);
    } else if (direction == 3 || direction == 4) {
      int col = blankLocation % size;
      return ((direction == 3) ? col != 0 : col != size - 1);
    } else {
      return false;
    }
  }
  
  /**
   * 
   * @param direction Arah pergerakan petak kosong (1: atas, 2: bawah, 3: kiri, 4: kanan).
   */
  public byte moveTo(int direction) {
    int destination = -1;
    if (direction == 1 || direction == 2) {
      destination = (direction == 1) ? blankLocation - size : blankLocation + size;
    } else if (direction == 3 || direction == 4) {
      destination = (direction == 3) ? blankLocation - 1 : blankLocation + 1;
    }
    if (destination != -1) {
      byte temp = tiles[blankLocation];
      tiles[blankLocation] = tiles[destination];
      byte value = tiles[destination];
      tiles[destination] = temp;
      blankLocation = (byte) destination;
      return value;
    } else {
      return -1;
    }
  }
  
  @Override
  public boolean equals(Object o) {
    if (o == null || !getClass().equals(o.getClass())) {
      return false;
    } else {
      Puzzle p = (Puzzle) o;
      int i = 0;
      boolean match = true;
      while (i < maxValue && match) {
        if (tiles[i] != p.tiles[i]) {
          match = false;
        } else {
          i++;
        }
      }
      return match;
    }
  }
}