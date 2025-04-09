//package ReservationSystem;
import javax.swing.*;
import java.awt.*;

public class ReservationForm extends JFrame {

    public ReservationForm() {
        setTitle("Book Ticket");
        setSize(400, 400);
        setLayout(null);

        JLabel[] labels = {
            new JLabel("Name:"), new JLabel("Train No:"), new JLabel("Class:"),
            new JLabel("Date (dd-mm-yyyy):"), new JLabel("From:"), new JLabel("To:")
        };

        JTextField[] fields = new JTextField[6];

        for (int i = 0; i < 6; i++) {
            labels[i].setBounds(30, 30 + (i * 40), 120, 25);
            labels[i].setFont(new Font("Segoe UI", Font.PLAIN, 12));
            labels[i].setForeground(new Color(150, 75, 100));
            fields[i] = new JTextField();
            fields[i].setBounds(160, 30 + (i * 40), 180, 25);
            add(labels[i]);
            add(fields[i]);
        }

        JButton book = new JButton("Confirm Booking");
        book.setBounds(120, 280, 150, 30);

        JLabel nLabel = new JLabel("— Santoshi");
        nLabel.setBounds(140, 330, 120, 20);
        nLabel.setFont(new Font("Segoe Script", Font.PLAIN, 12));
        nLabel.setForeground(new Color(150, 75, 100));

        add(book);
        add(nLabel);

        book.setBackground(new Color(255, 182, 193));
        book.setForeground(new Color(255, 255, 255));
        book.setFont(new Font("Segoe UI", Font.BOLD, 14));
        book.setFocusPainted(true);
        book.setBorderPainted(false);

        book.addActionListener(e -> {
            Reservation r = new Reservation(
                fields[0].getText(), fields[1].getText(), fields[2].getText(),
                fields[3].getText(), fields[4].getText(), fields[5].getText()
            );
            FileStorage.saveReservation(r);

          
            JPanel ticketPanel = new JPanel();
            ticketPanel.setLayout(new BoxLayout(ticketPanel, BoxLayout.Y_AXIS));
            ticketPanel.setBackground(new Color(255, 239, 245)); 

            ticketPanel.add(createStyledLabel("🎟️ PNR: " + r.pnr));
            ticketPanel.add(createStyledLabel("👤 Name: " + r.name));
            ticketPanel.add(createStyledLabel("🚆 Train No: " + r.trainNo));
            ticketPanel.add(createStyledLabel("🛤️ Train Name: " + r.trainName));
            ticketPanel.add(createStyledLabel("💺 Class: " + r.classType));
            ticketPanel.add(createStyledLabel("📅 Date: " + r.doj));
            ticketPanel.add(createStyledLabel("📍 From: " + r.from + " ➡️ " + r.to));

            JOptionPane.showMessageDialog(this, ticketPanel, "Ticket Booked", JOptionPane.INFORMATION_MESSAGE);
            dispose(); 
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 239, 245));
        setVisible(true);
    }
    private JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(new Color(75, 0, 130)); 
        label.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        return label;
    }

    public static void main(String[] args) {
        new ReservationForm();
    }
}
