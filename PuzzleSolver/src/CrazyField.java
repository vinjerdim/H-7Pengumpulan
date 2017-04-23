import javax.swing.JTextField;

public class CrazyField extends JTextField implements Runnable {
  private int delay;
  private int stopAt;
  private volatile boolean running = true;
  
  public CrazyField(int delay, int stopAt) {
    this.delay = delay;
    this.stopAt = stopAt;
  }
  
  @Override
  public void run() {
    // TODO Auto-generated method stub
    int i = 0;
    while (running) {
      try {
        setText(i + "");
        if (i == stopAt) {
          stop();
        } else {
          Thread.sleep(delay);
          i++;
        }
      } catch (InterruptedException ie) {
        setText("Interrupted");
        break;
      }
    }
  }

  public void stop() {
    running = false;
  }
}
