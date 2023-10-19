import java.io.IOException;
import java.util.Scanner;

public class ConsoleSystem {
    private final Scanner scanner = new Scanner(System.in);
    private Hotel currentHotel;
    private Hotel beachHotel;
    private Hotel mountainHotel;

    private UserSystem userSystem;

    public ConsoleSystem(Hotel beachHotel, Hotel mountainHotel) throws IOException, IOException {
        this.beachHotel = beachHotel;
        this.mountainHotel = mountainHotel;
        this.userSystem = new UserSystem();
    }

    public void start() throws IOException {
        System.out.println("Welcome to the Hotel Reservation System!");

        User loggedInUser = loginOrRegisterMenu();
        if (loggedInUser != null) {
            while (true) {
                selectHotelMenu();
                showMainMenu();
            }
        } else {
            System.out.println("Thank you for using the Hotel Reservation System!");
        }
    }


    private void selectHotelMenu() {
        while (true) {
            System.out.println("\n---- Select a Hotel ----");
            System.out.println("1. Beach Hotel");
            System.out.println("2. Mountain Hotel");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    currentHotel = beachHotel;
                    return;
                case 2:
                    currentHotel = mountainHotel;
                    return;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void showMainMenu() {
        while (true) {
            System.out.println("\n---- " + currentHotel.getName() + " ----");
            System.out.println("1. View Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Go back to hotel selection");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    viewRooms();
                    break;
                case 2:
                    bookRoom();
                    break;
                case 3:
                    cancelBooking();
                    break;
                case 4:
                    return;  // Go back to the main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public User loginOrRegisterMenu() throws IOException {
        while (true) {
            System.out.println("\n---- Login or Register ----");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    User user = userSystem.login();
                    if (user != null) {
                        return user;
                    }
                    break;
                case 2:
                    userSystem.register();
                    break;
                case 3:
                    return null;  // exit without logging in
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void viewRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room room : currentHotel.getRooms()) {
            if ("available".equalsIgnoreCase(room.getStatus())) {
                System.out.println(room);
            }
        }
    }

    private void bookRoom() {
        System.out.println("Enter the room number you want to book:");
        int roomNumber = scanner.nextInt();
        Room room = currentHotel.getRoom(roomNumber);

        if (room != null && "available".equalsIgnoreCase(room.getStatus())) {
            room.setStatus("booked");
            System.out.println("Room booked successfully!");
        } else {
            System.out.println("Room is either not available or doesn't exist.");
        }
    }

    private void cancelBooking() {
        System.out.println("Enter the room number of the booking you want to cancel:");
        int roomNumber = scanner.nextInt();
        Room room = currentHotel.getRoom(roomNumber);

        if (room != null && "booked".equalsIgnoreCase(room.getStatus())) {
            room.setStatus("available");
            System.out.println("Booking canceled successfully!");
        } else {
            System.out.println("Room is either not booked or doesn't exist.");
        }
    }
}
