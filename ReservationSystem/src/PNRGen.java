import java.util.UUID;

public class PNRGen {
    public static String generatePNR() {
        // Generate random unique string using UUID (first 8 characters)
        return "PNR" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
