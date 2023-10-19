import java.io.*;
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

    public static List<User> loadUsersFromCSV(String filename) throws IOException {
        List<User> users = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filename));
            String line;
            br.readLine(); // Skip the header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                User user = new User(values[0], values[1], Integer.parseInt(values[2]));
                users.add(user);
            }
        } finally {
            if (br != null) {
                br.close();
            }
        }
        return users;
    }


    public static void saveUserToCSV(User user, String path) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(path, true);
             OutputStreamWriter osw = new OutputStreamWriter(fos);
             BufferedWriter bw = new BufferedWriter(osw);
             PrintWriter out = new PrintWriter(bw)) {

            out.write("\n"); // new line in csv
            out.print(user.getUsername() + "," + user.getPassword() + "," + user.getUniqueID());
        }
    }


    public static int generateUniqueID(List<User> existingUsers) {
        int maxAttempts = 1000;
        int attempt = 0;

        while (attempt < maxAttempts) {
            int randomID = (int) (Math.random() * 1000) + 1;  // Generate a number between 1 and 1000 for simplicity

            boolean idExists = false;
            for (User user : existingUsers) {
                if (user.getUniqueID() == randomID) {
                    idExists = true;
                    break;
                }
            }

            if (!idExists) {
                return randomID;
            }

            attempt++;
        }

        // if we have 1000 users
        throw new RuntimeException("Unable to register a unique ID");
    }

}
