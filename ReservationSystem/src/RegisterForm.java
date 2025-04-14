import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RegisterForm extends JFrame {
    public RegisterForm() {
        setTitle("Register - Railway System");
        setSize(400, 450);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(255, 250, 240));

        JLabel title = new JLabel("🚂 Create New Account");
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        title.setBounds(80, 30, 250, 30);
        add(title);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(60, 100, 100, 25);
        add(userLabel);
        JTextField userField = new JTextField();
        userField.setBounds(150, 100, 150, 25);
        add(userField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(60, 150, 100, 25);
        add(passLabel);
        JPasswordField passField = new JPasswordField();
        passField.setBounds(150, 150, 150, 25);
        add(passField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(60, 200, 100, 25);
        add(emailLabel);
        JTextField emailField = new JTextField();
        emailField.setBounds(150, 200, 150, 25);
        add(emailField);

        JButton registerBtn = new JButton("Register");
        registerBtn.setBounds(130, 250, 120, 30);
        registerBtn.setBackground(new Color(144, 238, 144));
        add(registerBtn);

        JLabel msgLabel = new JLabel("");
        msgLabel.setBounds(80, 300, 250, 30);
        add(msgLabel);

        JButton loginBtn = new JButton("⬅ Back to Login");
        loginBtn.setBounds(110, 340, 160, 30);
        add(loginBtn);

        JLabel footer = new JLabel("✨ Designed by Santoshi");
        footer.setBounds(110, 390, 200, 20);
        footer.setFont(new Font("Segoe Script", Font.PLAIN, 11));
        add(footer);

        registerBtn.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());
            String email = emailField.getText();

            if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
                msgLabel.setText("⚠️ Please fill all fields.");
                return;
            }

            try {
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement("INSERT INTO users(username, password, email) VALUES(?, ?, ?)");
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setString(3, email);
                ps.executeUpdate();
                msgLabel.setText("✅ Registered successfully!");
            } catch (SQLException ex) {
                msgLabel.setText("❌ Username might already exist.");
                ex.printStackTrace();
            }
        });

        loginBtn.addActionListener(e -> {
            new LoginForm().setVisible(true);
            dispose();
        });
    }
}
