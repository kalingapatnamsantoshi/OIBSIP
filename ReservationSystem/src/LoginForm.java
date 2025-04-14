import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginForm() {
        setTitle("Login - Reservation System");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(255, 239, 246));

        Font txt = new Font("Segoe UI", Font.PLAIN, 14);

        JLabel titleLabel = new JLabel("Login");
        titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        titleLabel.setBounds(160, 20, 200, 30);
        add(titleLabel);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(80, 80, 100, 25);
        add(userLabel);
        usernameField = new JTextField();
        usernameField.setBounds(160, 80, 150, 25);
        usernameField.setFont(txt);
        add(usernameField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(80, 120, 100, 25);
        add(passLabel);
        passwordField = new JPasswordField();
        passwordField.setBounds(160, 120, 150, 25);
        passwordField.setFont(txt);
        add(passwordField);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(90, 170, 90, 30);
        loginBtn.setBackground(new Color(255, 182, 193));
        loginBtn.setForeground(Color.WHITE);
        add(loginBtn);

        JButton registerBtn = new JButton("Register");
        registerBtn.setBounds(200, 170, 100, 30);
        registerBtn.setBackground(new Color(255, 182, 193));
        registerBtn.setForeground(Color.WHITE);
        add(registerBtn);

        JLabel footer = new JLabel("✨ Designed by Santoshi");
        footer.setBounds(110, 240, 200, 20);
        footer.setFont(new Font("Segoe Script", Font.PLAIN, 11));
        add(footer);

        loginBtn.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (authenticate(username, password)) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                new Dashboard(username).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.");
            }
        });

        registerBtn.addActionListener(e -> {
            new RegisterForm().setVisible(true);
            dispose();
        });
    }

    private boolean authenticate(String username, String password) {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        new LoginForm().setVisible(true);
    }
}
