package gamecontroller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Kelas untuk menangani exception
 * @author Marvin Jerremy Budiman (13515076).
 */
public class GameException extends Exception {
  private static final long serialVersionUID = 1L;
  private JFrame frame;
  private int exceptionNumber;
  
  
  public GameException(JFrame f, int number) {
    frame = f;
    exceptionNumber = number;
  }
  
  /**
   * Menampilkan dialog error berdasarkan error yang terjadi.
   */
  public void showDialog() {
    if (exceptionNumber == 1) {
      JOptionPane.showMessageDialog(frame, "Input must be between 5 to 10");
    } else if (exceptionNumber == 2) {
      JOptionPane.showMessageDialog(frame, "Input must be between 0 to 2");
    } else if (exceptionNumber == 3) {
      JOptionPane.showMessageDialog(frame, "Input must be filled");
    }
  }
}