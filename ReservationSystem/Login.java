import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    public Login() {
        setTitle("Login - Reservation System");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(255, 239, 246));

        Font txt = new Font("Segoe UI", Font.PLAIN, 14);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(30, 30, 80, 25);
        JTextField userText = new JTextField();
        userText.setBounds(120, 30, 150, 25);
        userText.setFont(txt);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(30, 70, 80, 25);
        JPasswordField passText = new JPasswordField();
        passText.setBounds(120, 70, 150, 25);
        passText.setFont(txt);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(120, 110, 80, 25);
        loginButton.setBackground(new Color(255, 182, 193));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        loginButton.setFocusPainted(false);
        loginButton.setBorderPainted(false);

        add(userLabel);
        add(userText);
        add(passLabel);
        add(passText);
        add(loginButton);

        JLabel nameLabel = new JLabel("— Santoshi");
        nameLabel.setBounds(200, 145, 100, 20);
        nameLabel.setFont(new Font("Segoe Script", Font.PLAIN, 12));
        nameLabel.setForeground(new Color(150, 75, 100));
        add(nameLabel);

        loginButton.addActionListener(e -> {
            String username = userText.getText();
            String password = new String(passText.getPassword());

            if (username.equals("Santoshi") && password.equals("Password@123")) {
                JOptionPane.showMessageDialog(
                    this,
                    "🌸 Welcome back, Santoshi! 🌸\nYour journey awaits ✨",
                    "Login Successful",
                    JOptionPane.INFORMATION_MESSAGE
                );
                new Dashboard();
                dispose();
            } else {
                JOptionPane.showMessageDialog(
                    this,
                    "⚠️ Oops! That doesn’t look right.\nPlease check your username or password and try again 💫",
                    "Login Failed",
                    JOptionPane.WARNING_MESSAGE
                );
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
