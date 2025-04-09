//package ReservationSystem;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PNRGen {
    private static int counter = 1001;

    public static String generatePNR() {
        String datePrefix = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd")); 
        return "PNR-" + datePrefix + "-" + String.format("%05d", counter++);
    }

    public static void resetCounter(int startFrom) {
        counter = startFrom;
    }
}

