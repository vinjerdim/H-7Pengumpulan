/**
 * 
 */

package view;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public class MenuFrame extends JFrame {
  private JPanel optionsPanel;
  private JRadioButton[] optionItem = new JRadioButton[3];
  private ButtonGroup options;
  private JButton playButton;
  
  public MenuFrame() {
    super("Main Menu");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    
    JLabel title = new JLabel("The Puzzle Frenzy");
    title.setHorizontalAlignment(JLabel.CENTER);
    optionsPanel = new JPanel();
    optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
    optionsPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
    options = new ButtonGroup();
    
    playButton = new JButton("PLAY");
    playButton.addMouseListener(new SwitchToGame(this, optionItem));
    
    optionItem[0] = new JRadioButton("Single Player");
    optionItem[1] = new JRadioButton("Player vs Player");
    optionItem[2] = new JRadioButton("Player vs Computer");
    optionItem[0].setSelected(true);
    
    optionsPanel.add(title);
    for (int i = 0; i < optionItem.length; i++) {
      options.add(optionItem[i]);
      optionsPanel.add(optionItem[i]);
    }
    optionsPanel.add(playButton);
    
    add(optionsPanel, BorderLayout.CENTER);
    
    pack();
    setResizable(false);
    setVisible(true);
  }
}
