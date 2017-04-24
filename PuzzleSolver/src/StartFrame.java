import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class StartFrame implements MouseListener {
  private JFrame frame1;
  private JFrame frame2;
  
  public StartFrame(JFrame f1, JFrame f2) {
    frame1 = f1;
    frame2 = f2;
  }
  
  @Override
  public void mouseClicked(MouseEvent arg0) {
    // TODO Auto-generated method stub
    frame1.setEnabled(false);
    frame2.setVisible(true);
  }

  @Override
  public void mouseEntered(MouseEvent arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mouseExited(MouseEvent arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mousePressed(MouseEvent arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mouseReleased(MouseEvent arg0) {
    // TODO Auto-generated method stub
    
  }
  
}
