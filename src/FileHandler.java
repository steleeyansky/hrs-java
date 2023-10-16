import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    public static List<Room> loadRoomsFromCSV(String filePath) throws IOException {
        List<Room> rooms = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            String line;
            // skipping the header line of the csv
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                int roomNumber = Integer.parseInt(values[0]);
                String type = values[1];
                int pricePerNight = Integer.parseInt(values[2]);
                int cancellationFee = Integer.parseInt(values[3]);
                String status = values[4];

                rooms.add(new Room(roomNumber, type, pricePerNight, cancellationFee, status));
            }
        }

        return rooms;
    }
}
