import javax.swing.*;
import java.awt.event.*;

// Custom event class
class AlarmEvent {
    private final Object source;

    public AlarmEvent(Object source) {
        this.source = source;
    }

    public Object getSource() {
        return source;
    }
}

// Custom listener interface
interface AlarmListener {
    void onAlarmTriggered(AlarmEvent event);
}

// Alarm handler class implementing the listener
class AlarmHandler implements AlarmListener {
    @Override
    public void onAlarmTriggered(AlarmEvent event) {
        System.out.println("Alarm triggered! Source: " + event.getSource());
        JOptionPane.showMessageDialog(null, "Alarm triggered!");
    }
}

// Main class
public class Demo14 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Custom Event Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JButton triggerButton = new JButton("Trigger Alarm");
        AlarmHandler alarmHandler = new AlarmHandler();

        triggerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AlarmEvent alarmEvent = new AlarmEvent(triggerButton);
                alarmHandler.onAlarmTriggered(alarmEvent);
            }
        });

        frame.setLayout(new java.awt.FlowLayout());
        frame.add(triggerButton);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
