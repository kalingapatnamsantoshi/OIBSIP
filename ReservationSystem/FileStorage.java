import java.io.*;
import java.util.*;
import java.nio.file.Files;

public class FileStorage {
    public static final String RESERVATION_FILE = "data/reservations.txt";
    public static final String CANCELLATION_FILE = "data/cancellations.txt";

    public static void saveReservation(Reservation r) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RESERVATION_FILE, true))) {
            writer.write(r.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean cancelReservation(String pnr) {
        File inputFile = new File(RESERVATION_FILE);
        File tempFile = new File("data/temp_reservations.txt");
        boolean found = false;
        String cancelledLine = null;

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(pnr)) {
                    cancelledLine = line;
                    found = true;
                } else {
                    writer.write(line);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (found && cancelledLine != null) {
            try {
                Files.delete(inputFile.toPath());
                tempFile.renameTo(inputFile);

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(CANCELLATION_FILE, true))) {
                    writer.write(cancelledLine);
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            tempFile.delete(); // Clean up
        }

        return found;
    }
}
