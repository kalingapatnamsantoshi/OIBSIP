import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class CancelTickets extends JFrame {
    private String username;
    private JTextField pnrField;
    private JLabel messageLabel;

    public CancelTickets(String username) {
        this.username = username;

        setTitle("Cancel Ticket - Reservation System");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(255, 239, 246));

        Font font = new Font("Segoe UI", Font.PLAIN, 14);

        JLabel titleLabel = new JLabel("Cancel Your Ticket");
        titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        titleLabel.setBounds(100, 20, 250, 30);
        add(titleLabel);

        JLabel pnrLabel = new JLabel("Enter PNR:");
        pnrLabel.setBounds(80, 80, 100, 25);
        add(pnrLabel);

        pnrField = new JTextField();
        pnrField.setBounds(160, 80, 140, 25);
        pnrField.setFont(font);
        add(pnrField);

        JButton cancelBtn = new JButton("Cancel Ticket");
        cancelBtn.setBounds(130, 130, 140, 30);
        cancelBtn.setBackground(new Color(255, 182, 193));
        cancelBtn.setForeground(Color.WHITE);
        add(cancelBtn);

        messageLabel = new JLabel("");
        messageLabel.setBounds(50, 170, 300, 25);
        messageLabel.setFont(font);
        messageLabel.setForeground(Color.RED);
        add(messageLabel);

        JButton backBtn = new JButton("⬅ Back");
        backBtn.setBounds(130, 210, 120, 30);
        add(backBtn);

        JLabel footer = new JLabel("✨ Designed by Santoshi");
        footer.setBounds(110, 250, 200, 20);
        footer.setFont(new Font("Segoe Script", Font.PLAIN, 11));
        add(footer);

        cancelBtn.addActionListener(e -> cancelTicket());
        backBtn.addActionListener(e -> {
            new Dashboard(username).setVisible(true);
            dispose();
        });
    }

    private void cancelTicket() {
        String pnr = pnrField.getText().trim();

        if (pnr.isEmpty()) {
            messageLabel.setText("⚠️ Please enter a valid PNR.");
            return;
        }

        File inputFile = new File("bookings.csv");
        File tempFile = new File("temp.csv");
        boolean found = false;

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(pnr)) {
                    found = true;
                    continue; // skip writing this line (i.e., delete it)
                }
                writer.write(line);
                writer.newLine();
            }

            writer.close();
            reader.close();

            if (inputFile.delete() && tempFile.renameTo(inputFile)) {
                if (found) {
                    JOptionPane.showMessageDialog(this, "✅ Ticket with PNR " + pnr + " has been cancelled.");
                    messageLabel.setText("");
                } else {
                    messageLabel.setText("❌ No ticket found with given PNR.");
                }
            } else {
                messageLabel.setText("⚠️ Error while updating bookings.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            messageLabel.setText("❌ Error while cancelling ticket.");
        }
    }
}
