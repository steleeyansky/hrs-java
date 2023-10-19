import java.io.IOException;
import java.util.List;


// Притисна ме времето и не съм го усъвършенствал, в момента всеки user може да канселира, за в бъдеще ще го оправя :D
public class Main {
    public static void main(String[] args) throws IOException {
        List<Room> beachRooms;
        List<Room> mountainRooms;

        try {
            beachRooms = FileHandler.loadRoomsFromCSV("src/rooms-beach.csv");
            mountainRooms = FileHandler.loadRoomsFromCSV("src/rooms-mountain.csv");
        } catch (IOException e) {
            System.out.println("Error reading the room data files.");
            e.printStackTrace();
            return;
        }

        Hotel beachHotel = new Hotel("Beach Hotel", beachRooms);
        Hotel mountainHotel = new Hotel("Mountain Hotel", mountainRooms);

        ConsoleSystem consoleSystem = new ConsoleSystem(beachHotel, mountainHotel);
        consoleSystem.start();
    }
}
