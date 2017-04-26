package gamecontroller;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * Kelas MenuFrame untuk view Menu
 * 
 * @author Muhamad Irfan Maulana (13515037).
 *
 */
public class MenuFrame extends JFrame {
  private static final long serialVersionUID = 1L;
  private JPanel optionsPanel;
  private JRadioButton[] optionItem = new JRadioButton[3];
  private ButtonGroup options;
  private JButton playButton;
 
  /**
   * Konstruktor MenuFrame.
   */
  public MenuFrame() {
    super("Main Menu");
    setLayout(new GridLayout(1,1));
    setLocation(100, 100);
    
    JLabel title = new JLabel("Slide The Numbers");
    title.setHorizontalAlignment(JLabel.CENTER);
    title.setFont(new Font("SANS SERIF", Font.TRUETYPE_FONT, 24));
    
    optionsPanel = new JPanel();
    optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
    options = new ButtonGroup();
    
    optionItem[0] = new JRadioButton("Single Player");
    optionItem[1] = new JRadioButton("Player vs Player");
    optionItem[2] = new JRadioButton("Player vs Computer");
    optionItem[0].setSelected(true);

    for (int i = 0; i < optionItem.length; i++) {
      optionItem[i].setFont(new Font("SANS SERIF", Font.TRUETYPE_FONT, 14));
      options.add(optionItem[i]);
      optionsPanel.add(optionItem[i]);
    }
    
    playButton = new JButton("PLAY");
    playButton.addMouseListener(new SwitchToGame(this, optionItem));
    
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());
    mainPanel.setBorder(BorderFactory.createEmptyBorder(50, 20, 50, 20));
    mainPanel.add(title, BorderLayout.PAGE_START);
    mainPanel.add(optionsPanel, BorderLayout.CENTER);
    mainPanel.add(playButton, BorderLayout.PAGE_END);
    add(mainPanel, BorderLayout.CENTER);
    
    addWindowListener(new ShowMetrics(this));
    
    pack();
    setResizable(false);
    setVisible(true);
  }
  
  private class ShowMetrics implements WindowListener {
    private MenuFrame menuFrame;
    
    public ShowMetrics(MenuFrame f) {
      menuFrame = f;
    }

    @Override
    public void windowActivated(WindowEvent arg0) {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void windowClosed(WindowEvent arg0) {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void windowClosing(WindowEvent arg0) {
      // TODO Auto-generated method stub
      File fileImage = new File("res/metrics.jpg");
      BufferedImage image;
      try {
        image = ImageIO.read(fileImage);
        JOptionPane.showMessageDialog(menuFrame, new ImageIcon(image));
        menuFrame.dispose();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }

    @Override
    public void windowDeactivated(WindowEvent arg0) {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void windowDeiconified(WindowEvent arg0) {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void windowIconified(WindowEvent arg0) {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void windowOpened(WindowEvent arg0) {
      // TODO Auto-generated method stub
      
    }
  }
}
