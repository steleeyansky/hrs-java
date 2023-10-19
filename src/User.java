public class User {
    private String username;
    private String password;
    private int uniqueID;

    public User(String username, String password, int uniqueID) {
        this.username = username;
        this.password = password;
        this.uniqueID = uniqueID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(int uniqueID) {
        this.uniqueID = uniqueID;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", uniqueID=" + uniqueID +
                '}';
    }
}
