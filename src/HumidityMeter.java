import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by Gray on 28.03.2015.
 */
public class HumidityMeter extends JFrame {

    // Тестовая вставка

    private JTree tree;
    private JLabel selectedLabel;

    public HumidityMeter() {

        //Menu
        JMenuBar menuBar = new JMenuBar();

        //file menu
        JMenu menuFile = new JMenu("File");
        JMenuItem menuItemNew = new JMenuItem("New");
        JMenuItem menuItemOpen = new JMenuItem("Open");
        JMenuItem menuItemSave = new JMenuItem("Save");
        JMenuItem menuItemExit = new JMenuItem("Exit");
        menuFile.add(menuItemNew);
        menuFile.add(menuItemOpen);
        menuFile.add(menuItemSave);
        menuFile.add(menuItemExit);
        menuBar.add(menuFile);

        menuItemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //connection menu
        JMenu menuConnection = new JMenu("Connection");
        JMenuItem menuItemConnect = new JMenuItem("Connect");
        JMenuItem menuItemDisconnect = new JMenuItem("Disconnect");
        JMenuItem menuItemConnectionSetup = new JMenuItem("Setup Connection");
        menuConnection.add(menuItemConnect);
        menuConnection.add(menuItemDisconnect);
        menuConnection.add(menuItemConnectionSetup);
        menuBar.add(menuConnection);

        //setup menu
        JMenu menuSetup = new JMenu("Setup");
        JMenuItem menuItemLoadPreset = new JMenuItem("Load Preset");
        JMenuItem menuItemSavePreset = new JMenuItem("Save Preset");
        JMenuItem menuItemBoardSetup = new JMenuItem("Board Setup");
        JMenuItem menuItemCoefficientSetup = new JMenuItem("Setup Coefficient");
        JMenuItem menuItemOutputSetup = new JMenuItem("Setup Output");
        JMenuItem menuItemCalibrate = new JMenuItem("Calibrate");
        JMenuItem menuItemResonanceSeek = new JMenuItem("Seek Resonance");
        menuSetup.add(menuItemLoadPreset);
        menuSetup.add(menuItemSavePreset);
        menuSetup.add(menuItemBoardSetup);
        menuSetup.add(menuItemCoefficientSetup);
        menuSetup.add(menuItemOutputSetup);
        menuSetup.add(menuItemCalibrate);
        menuSetup.add(menuItemResonanceSeek);
        menuBar.add(menuSetup);

        //help menu
        JMenu menuHelp = new JMenu("Help");
        JMenuItem menuItemTopics = new JMenuItem("Help Topics");
        JMenuItem menuItemAbout = new JMenuItem("About");
        menuHelp.add(menuItemTopics);
        menuHelp.add(menuItemAbout);
        menuBar.add(menuHelp);

        setJMenuBar(menuBar);

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
        add(new JScrollPane(tree), BorderLayout.WEST);
        tree.setShowsRootHandles(true);
        tree.setRootVisible(false);

        selectedLabel = new JLabel();
        add(selectedLabel, BorderLayout.SOUTH);

        tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                selectedLabel.setText(selectedNode.getUserObject().toString());
            }
        });


        //frame setup
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Humidity Meter");
        this.pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HumidityMeter().setVisible(true);
            }
        });
    }
}
