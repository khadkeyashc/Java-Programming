import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Demo10 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple GUI Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        
        JLabel label = new JLabel("Enter text and click the button:");
        
        JTextField textField = new JTextField(20);
        
        JButton button = new JButton("Display Text");
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("You entered: " + textField.getText());
            }
        });
        
        panel.add(label);
        panel.add(textField);
        panel.add(button);
        
        frame.add(panel);
        
        frame.setLocationRelativeTo(null);  // Center the window
        frame.setVisible(true);
    }
}

