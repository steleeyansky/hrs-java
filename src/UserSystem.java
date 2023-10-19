import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserSystem {
    private List<User> users;
    private String userFilePath = "src/users.csv";  // Update with the correct path if necessary

    public UserSystem() throws IOException {
        this.users = FileHandler.loadUsersFromCSV(userFilePath);
    }

    public User login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }

        System.out.println("Invalid credentials. Please try again.");
        return null;
    }

    public void register() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter desired username: ");
        String username = scanner.nextLine();
        System.out.println("Enter desired password: ");
        String password = scanner.nextLine();

        int uniqueID = FileHandler.generateUniqueID(users);
        User newUser = new User(username, password, uniqueID);
        users.add(newUser);
        FileHandler.saveUserToCSV(newUser, userFilePath);

        System.out.println("Registration successful! Your unique ID is: " + uniqueID);
    }
}
