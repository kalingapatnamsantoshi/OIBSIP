import javax.swing.*;
import java.awt.*;

public class CancellationForm extends JFrame {
    public CancellationForm() {
        setTitle("Cancel Ticket");
        setSize(400, 300);
        setLayout(null);

        JLabel label = new JLabel("Enter PNR:");
        label.setBounds(30, 40, 80, 25);
        JTextField pnrField = new JTextField();
        pnrField.setBounds(110, 40, 200, 25);

        JButton cancelBtn = new JButton("Cancel Ticket");
        cancelBtn.setBounds(130, 100, 130, 30);

        JLabel myLabel = new JLabel("— Santoshi");
        myLabel.setBounds((400 - 120) / 2, 240, 120, 20);
        myLabel.setFont(new Font("Segoe Script", Font.PLAIN, 12));
        myLabel.setForeground(new Color(150, 75, 100));

        add(label);
        add(pnrField);
        add(cancelBtn);
        add(myLabel);

        cancelBtn.addActionListener(e -> {
            String pnr = pnrField.getText().trim();
            boolean success = FileStorage.cancelReservation(pnr);

            if (success) {
                JOptionPane.showMessageDialog(this, "✅ Ticket Cancelled for PNR: " + pnr);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "❌ PNR not found. Please check again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 239, 246));
        setVisible(true);
    }

    public static void main(String[] args) {
        new CancellationForm();
    }
}
