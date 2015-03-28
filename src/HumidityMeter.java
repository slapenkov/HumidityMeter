import javax.swing.*;

/**
 * Created by Gray on 28.03.2015.
 */
public class HumidityMeter extends JFrame {

    private JTree tree;

    public HumidityMeter() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Humidity Meter");
        this.setSize(275, 100);
        //this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HumidityMeter();
            }
        });
    }
}
