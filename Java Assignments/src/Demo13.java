import javax.swing.*;
import java.awt.event.*;

public class Demo13 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Event Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Button 1 clicked!");
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Button 2 clicked!");
            }
        });

        frame.setLayout(new java.awt.FlowLayout());
        frame.add(button1);
        frame.add(button2);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
