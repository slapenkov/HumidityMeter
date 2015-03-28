import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Created by Gray on 28.03.2015.
 */
public class HumidityMeter extends JFrame {

    private JTree tree;

    public HumidityMeter() {

        //Tree
        //root node
        DefaultMutableTreeNode root = new DefaultMutableTreeNode();

        //sensor 1 node
        DefaultMutableTreeNode sensor1 = new DefaultMutableTreeNode("Sensor 1");
        //subnode
        DefaultMutableTreeNode board1 = new DefaultMutableTreeNode("Board 1");
        sensor1.add(board1);

        //sensor 2 node
        DefaultMutableTreeNode sensor2 = new DefaultMutableTreeNode("Sensor 2");
        //subnode
        DefaultMutableTreeNode board2 = new DefaultMutableTreeNode("Board 2");
        sensor2.add(board2);

        root.add(sensor1);
        root.add(sensor2);

        tree = new JTree(root);
        add(tree);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Humidity Meter");
        this.pack();
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
