import javax.swing.JTextField;

public class CrazyField extends JTextField implements Runnable {
  private int delay;
  private int stopAt;
  
  public CrazyField(int delay, int stopAt) {
    this.delay = delay;
    this.stopAt = stopAt;
  }
  
  @Override
  public void run() {
    // TODO Auto-generated method stub
    int i = 0;
    while (true) {
      try {
        setText(i + "");
        if (i == stopAt) {
          Thread.currentThread().interrupt();
        }
        Thread.sleep(delay);
        i++;
      } catch (InterruptedException ie) {
        setText("Interrupted");
        break;
      }
    }
  }

}
