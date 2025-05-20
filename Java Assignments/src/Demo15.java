import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Demo15 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/student_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    private JTextField idField, nameField, ageField, gradeField;
    private JTextArea outputArea;

    public Demo15() {
        JFrame frame = new JFrame("Student CRUD Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));
        panel.setBackground(Color.LIGHT_GRAY);

        JLabel idLabel = new JLabel("Student ID:");
        JLabel nameLabel = new JLabel("Name:");
        JLabel ageLabel = new JLabel("Age:");
        JLabel gradeLabel = new JLabel("Grade:");

        idField = new JTextField();
        nameField = new JTextField();
        ageField = new JTextField();
        gradeField = new JTextField();

        JButton createButton = new JButton("Create");
        JButton readButton = new JButton("Read");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        createButton.setBackground(Color.GREEN);
        readButton.setBackground(Color.BLUE);
        updateButton.setBackground(Color.ORANGE);
        deleteButton.setBackground(Color.RED);

        createButton.addActionListener(e -> createStudent());
        readButton.addActionListener(e -> readStudents());
        updateButton.addActionListener(e -> updateStudent());
        deleteButton.addActionListener(e -> deleteStudent());

        panel.add(idLabel);
        panel.add(idField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(gradeLabel);
        panel.add(gradeField);
        panel.add(createButton);
        panel.add(readButton);
        panel.add(updateButton);
        panel.add(deleteButton);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    private void createStudent() {
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String grade = gradeField.getText();

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO student (name, age, grade) VALUES (?, ?, ?)")) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, grade);
            stmt.executeUpdate();
            outputArea.setText("Student added successfully!");
        } catch (SQLException ex) {
            outputArea.setText("Error: " + ex.getMessage());
        }
    }

    private void readStudents() {
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM student")) {
            StringBuilder builder = new StringBuilder();
            while (rs.next()) {
                builder.append("ID: ").append(rs.getInt("student_id"))
                        .append(", Name: ").append(rs.getString("name"))
                        .append(", Age: ").append(rs.getInt("age"))
                        .append(", Grade: ").append(rs.getString("grade"))
                        .append("\n");
            }
            outputArea.setText(builder.toString());
        } catch (SQLException ex) {
            outputArea.setText("Error: " + ex.getMessage());
        }
    }

    private void updateStudent() {
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String grade = gradeField.getText();

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement("UPDATE student SET name = ?, age = ?, grade = ? WHERE student_id = ?")) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, grade);
            stmt.setInt(4, id);
            int rowsUpdated = stmt.executeUpdate();
            outputArea.setText(rowsUpdated > 0 ? "Student updated successfully!" : "Student not found.");
        } catch (SQLException ex) {
            outputArea.setText("Error: " + ex.getMessage());
        }
    }

    private void deleteStudent() {
        int id = Integer.parseInt(idField.getText());

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM student WHERE student_id = ?")) {
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            outputArea.setText(rowsDeleted > 0 ? "Student deleted successfully!" : "Student not found.");
        } catch (SQLException ex) {
            outputArea.setText("Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Demo15::new);
    }
}
