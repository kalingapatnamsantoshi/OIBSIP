import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/reservation_system";
    private static final String USER = "root";        
    private static final String PASSWORD = "";        

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("❌ Error connecting to DB: " + e.getMessage());
            return null;
        }
    }
}
