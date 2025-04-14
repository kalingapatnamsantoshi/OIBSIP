import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class ViewBookings extends JFrame {
    public ViewBookings(String username) {
        setTitle("Your Bookings");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JTextArea area = new JTextArea();
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area);
        add(scroll, BorderLayout.CENTER);

        JButton back = new JButton("⬅ Back");
        add(back, BorderLayout.SOUTH);

        back.addActionListener(e -> {
            new Dashboard(username).setVisible(true);
            dispose();
        });

        try (BufferedReader br = new BufferedReader(new FileReader("bookings.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(username + ",")) {
                    String[] parts = line.split(",");
                    area.append("🎫 PNR: " + parts[1] + ", Name: " + parts[2] + ", Train: " + parts[3] + " (" + parts[4] + ")\n");
                }
            }
        } catch (IOException e) {
            area.setText("❌ Error reading bookings.");
        }
    }
}
