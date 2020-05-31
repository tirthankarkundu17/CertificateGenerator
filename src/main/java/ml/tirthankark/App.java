package ml.tirthankark;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    private JPanel panelMain;
    private JTextField tfUsername;
    private JTextField tfLogSearch;
    private JCheckBox checkBox1;
    private JButton getLogsButton;

    public App() {
//        getLogsButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Event triggered!");
//            }
//        });
    }

    public static void main(String[] args) {
        JFrameCustom jFrame = new JFrameCustom("Property Encoder Decoder - Tirthankar Kundu");
        ImageIcon img = new ImageIcon("utility/icon.png");
        Dimension dimension = new Dimension(500, 500);
        jFrame.setMaximumSize(dimension);
        jFrame.setSize(dimension);
        jFrame.setIconImage(img.getImage());
        jFrame.setContentPane(new App().panelMain);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
