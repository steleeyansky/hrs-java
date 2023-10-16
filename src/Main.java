import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Room> beachRooms = null;
        List<Room> mountainRooms = null;
        ConsoleSystem consoleSystem = new ConsoleSystem();
        consoleSystem.showMainMenu();
        try {
            beachRooms = FileHandler.loadRoomsFromCSV("src/rooms-beach.csv");
            mountainRooms = FileHandler.loadRoomsFromCSV("src/rooms-mountain.csv");
        } catch (IOException e) {
            System.out.println("Error reading the room data files.");
            e.printStackTrace();
            return;
        }
    }
}