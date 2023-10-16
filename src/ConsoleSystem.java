import java.util.Scanner;

public class ConsoleSystem {
    private final Scanner scanner = new Scanner(System.in);
    private Hotel currentHotel;
    private Hotel beachHotel;
    private Hotel mountainHotel;

    public ConsoleSystem(Hotel beachHotel, Hotel mountainHotel) {
        this.beachHotel = beachHotel;
        this.mountainHotel = mountainHotel;
    }

    public void start() {

        while (true) {
            System.out.println("Welcome to the Hotel Reservation System!");
            System.out.println("Please choose a hotel:");
            System.out.println("1. Beach Hotel");
            System.out.println("2. Mountain Hotel");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    currentHotel = beachHotel;
                    showMainMenu();
                    break;
                case 2:
                    currentHotel = mountainHotel;
                    showMainMenu();
                    break;
                case 3:
                    System.out.println("Thank you for using the Hotel Reservation System!");
                    return;
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

    private void viewRooms() {
        // TODO: Implement the logic to view rooms
    }

    private void bookRoom() {
        // TODO: Implement the logic to book a room
    }

    private void cancelBooking() {
        // TODO: Implement the logic to cancel a booking
    }
}
