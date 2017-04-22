import java.awt.GridLayout;

import javax.swing.JFrame;

public class TryThread {
  /**
   * 
   * @param args Argumen program.
   */
  public static void main(String[] args) {
    JFrame main = new JFrame("Main");
    main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    main.setLayout(new GridLayout(1,2));
    
    CrazyField c1 = new CrazyField(200, 50);
    CrazyField c2 = new CrazyField(800, 50);
    
    main.add(c1);
    main.add(c2);
    Thread t1 = new Thread(c1);
    Thread t2 = new Thread(c2);
    t1.start();
    t2.start();
    
    main.pack();
    main.setVisible(true);
  }
}
