import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class Hotel {
    private String name;
    private List<Room> rooms;

    public Hotel(String name, List<Room> rooms) {
        this.name = name;
        this.rooms = rooms;
    }

    // Method to add a room to the hotel
    public void addRoom(Room room) {
        rooms.add(room);
    }

    // Method to remove a room from the hotel
    public void removeRoom(int roomNumber) {
        rooms.removeIf(room -> room.getRoomNumber() == roomNumber);
    }

    // Method to get a room by its room number
    public Room getRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    // Method to get all floors in the hotel
    public Set<Integer> getAllFloors() {
        Set<Integer> floors = new HashSet<>();
        for (Room room : rooms) {
            floors.add(room.getFloor());
        }
        return floors;
    }

    // Method to get available rooms on a particular floor
    public List<Room> getAvailableRoomsOnFloor(int floor) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getFloor() == floor && "available".equalsIgnoreCase(room.getStatus())) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    @Override
    public String toString() {
        return "Hotel: " + name + ", Rooms: " + rooms.toString();
    }
}
