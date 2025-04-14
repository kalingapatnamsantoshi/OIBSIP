import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class BookTicket extends JFrame {
    private String username;
    private JTextField nameField, trainNoField, classField, dateField, fromField, toField;

    public BookTicket(String username) {
        this.username = username;
        setTitle("Book Ticket");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel label = new JLabel("Book Ticket - Welcome " + username);
        label.setBounds(80, 20, 300, 30);
        add(label);

        // Form fields
        nameField = createTextField("Passenger Name", 60);
        trainNoField = createTextField("Train No", 100);
        classField = createTextField("Class Type (e.g. Sleeper)", 140);
        dateField = createTextField("Date of Journey (YYYY-MM-DD)", 180);
        fromField = createTextField("From", 220);
        toField = createTextField("To", 260);

        JButton bookBtn = new JButton("Book Now");
        bookBtn.setBounds(130, 300, 120, 30);
        add(bookBtn);

        JLabel msgLabel = new JLabel("");
        msgLabel.setBounds(50, 340, 300, 30);
        add(msgLabel);

        JButton back = new JButton("⬅ Back");
        back.setBounds(130, 380, 120, 30);
        add(back);

        JLabel footer = new JLabel("✨ Designed by Santoshi");
        footer.setBounds(10, 430, 300, 20);
        footer.setFont(new Font("SansSerif", Font.PLAIN, 11));
        add(footer);

        bookBtn.addActionListener(e -> {
            String name = nameField.getText();
            String trainNo = trainNoField.getText();
            String classType = classField.getText();
            String doj = dateField.getText();
            String from = fromField.getText();
            String to = toField.getText();

            if (name.isEmpty() || trainNo.isEmpty() || classType.isEmpty() || doj.isEmpty() || from.isEmpty() || to.isEmpty()) {
                msgLabel.setText("⚠️ Please fill all fields.");
                return;
            }

            Reservation r = new Reservation(name, trainNo, classType, doj, from, to);
            saveToFile(r);
            JOptionPane.showMessageDialog(this, r.toPrettyString(), "Ticket Booked!", JOptionPane.INFORMATION_MESSAGE);
        });

        back.addActionListener(e -> {
            new Dashboard(username).setVisible(true);
            dispose();
        });
    }

    private JTextField createTextField(String placeholder, int y) {
        JLabel label = new JLabel(placeholder);
        label.setBounds(50, y, 150, 20);
        add(label);
        JTextField field = new JTextField();
        field.setBounds(200, y, 130, 25);
        add(field);
        return field;
    }

    private void saveToFile(Reservation r) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("bookings.csv", true))) {
            bw.write(username + "," + r.toString());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("❌ Error saving to file: " + e.getMessage());
        }
    }
}
