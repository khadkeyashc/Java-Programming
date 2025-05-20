import javax.swing.*;
import java.awt.*;

public class Demo11 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Layout Manager Experiment");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel borderPanel = new JPanel(new BorderLayout());
        borderPanel.add(new JButton("Button 1 (North)"), BorderLayout.NORTH);
        borderPanel.add(new JButton("Button 2 (South)"), BorderLayout.SOUTH);
        borderPanel.add(new JButton("Button 3 (East)"), BorderLayout.EAST);
        borderPanel.add(new JButton("Button 4 (West)"), BorderLayout.WEST);
        borderPanel.add(new JButton("Button 5 (Center)"), BorderLayout.CENTER);

        JPanel flowPanel = new JPanel(new FlowLayout());
        flowPanel.add(new JButton("Button 6"));
        flowPanel.add(new JButton("Button 7"));
        flowPanel.add(new JButton("Button 8"));

        JPanel gridPanel = new JPanel(new GridLayout(2, 2));
        gridPanel.add(new JButton("Button 9"));
        gridPanel.add(new JButton("Button 10"));
        gridPanel.add(new JButton("Button 11"));
        gridPanel.add(new JButton("Button 12"));

        JPanel boxPanel = new JPanel();
        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));
        boxPanel.add(new JButton("Button 13"));
        boxPanel.add(new JButton("Button 14"));
        boxPanel.add(new JButton("Button 15"));

        frame.setLayout(new GridLayout(2, 2));
        frame.add(borderPanel);
        frame.add(flowPanel);
        frame.add(gridPanel);
        frame.add(boxPanel);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
