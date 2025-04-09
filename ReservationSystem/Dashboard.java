import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {
    public Dashboard() {
        setTitle("Santhu Dashboard - Reservation System");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JButton bookButton = new JButton("Book Ticket");
        bookButton.setBounds(100, 50, 200, 40);
        bookButton.setBackground(new Color(255, 182, 193));
        bookButton.setForeground(Color.WHITE);
        bookButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        bookButton.setFocusPainted(false);
        bookButton.setBorderPainted(false);

        JButton cancelButton = new JButton("Cancel Ticket");
        cancelButton.setBounds(100, 110, 200, 40);
        cancelButton.setBackground(new Color(255, 182, 193));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        cancelButton.setFocusPainted(false);
        cancelButton.setBorderPainted(false);

        JLabel name = new JLabel("-Santoshi");
        name.setBounds(200, 160, 100, 20);
        name.setFont(new Font("Segoe Script", Font.PLAIN, 12));
        name.setForeground(new Color(150, 75, 100));

        add(bookButton);
        add(cancelButton);
        add(name);

        bookButton.addActionListener(e -> new ReservationForm());
        cancelButton.addActionListener(e -> new CancellationForm());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
