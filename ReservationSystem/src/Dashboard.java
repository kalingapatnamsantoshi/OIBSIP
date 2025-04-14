import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame {
    private String username;

    public Dashboard(String username) {
        this.username = username;

        setTitle("Dashboard - Online Reservation System");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(255, 239, 246));

        JLabel welcomeLabel = new JLabel("Welcome, " + username + "!");
        welcomeLabel.setBounds(100, 30, 300, 30);
        welcomeLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        add(welcomeLabel);

        JButton bookTicketBtn = new JButton("🎫 Book Ticket");
        bookTicketBtn.setBounds(120, 90, 150, 30);
        bookTicketBtn.setBackground(new Color(255, 182, 193));
        bookTicketBtn.setForeground(Color.WHITE);
        add(bookTicketBtn);

        JButton cancelTicketBtn = new JButton("❌ Cancel Ticket");
        cancelTicketBtn.setBounds(120, 140, 150, 30);
        cancelTicketBtn.setBackground(new Color(255, 182, 193));
        cancelTicketBtn.setForeground(Color.WHITE);
        add(cancelTicketBtn);

        JButton logoutBtn = new JButton("🚪 Logout");
        logoutBtn.setBounds(120, 190, 150, 30);
        logoutBtn.setBackground(new Color(240, 128, 128));
        logoutBtn.setForeground(Color.WHITE);
        add(logoutBtn);

        JLabel footer = new JLabel("✨ Designed by Santoshi");
        footer.setBounds(110, 330, 200, 20);
        footer.setFont(new Font("Segoe Script", Font.PLAIN, 11));
        footer.setForeground(new Color(150, 75, 100));
        add(footer);

        // Button Actions
        bookTicketBtn.addActionListener(e -> {
            new BookTicket(username).setVisible(true);
            dispose();
        });

        cancelTicketBtn.addActionListener(e -> {
            new CancelTickets(username).setVisible(true);
            dispose();
        });

        logoutBtn.addActionListener(e -> {
            new LoginForm().setVisible(true);
            dispose();
        });
    }
}
