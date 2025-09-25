// User.java
public class User {
    private int userId;
    private String name;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name.trim();
    }

    public int getUserId() { return userId; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return String.format("UserID: %d | Name: %s", userId, name);
    }
}
