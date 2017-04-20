
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MainTest {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    JFrame main = new JFrame();
    
    JLabel label = new JLabel("EXAMPLE");
    label.setBounds(130,50, 150, 40);
    
    JButton button = new JButton("NICE");
    button.setBounds(130,100,100,40);
    button.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        int x = button.getLocation().x;
        int y = button.getLocation().y;
        button.setLocation(x + 10, y);
      }
    });
        
    main.add(button);
    main.add(label);
    main.setSize(400, 500);
    main.setLayout(null);
    main.setVisible(true);
    
  }

}
