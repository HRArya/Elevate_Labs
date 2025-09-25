// Library.java
import java.util.ArrayList;
import java.util.HashMap;


public class Library {
    private final ArrayList<Book> books = new ArrayList<>();
    private final ArrayList<User> users = new ArrayList<>();
    // Map bookId -> userId (who currently has the book)
    private final HashMap<Integer, Integer> issuedMap = new HashMap<>();

    // Add book (no duplicate IDs allowed)
    public boolean addBook(Book b) {
        if (findBook(b.getId()) != null) return false;
        books.add(b);
        return true;
    }

    // Add user (no duplicate IDs allowed)
    public boolean addUser(User u) {
        if (findUser(u.getUserId()) != null) return false;
        users.add(u);
        return true;
    }

    public Book findBook(int id) {
        for (Book b : books) if (b.getId() == id) return b;
        return null;
    }

    public User findUser(int id) {
        for (User u : users) if (u.getUserId() == id) return u;
        return null;
    }

    // Issue a book to a user
    public boolean issueBook(int bookId, int userId) {
        Book b = findBook(bookId);
        if (b == null) return false;              // book doesn't exist
        if (b.isIssued()) return false;           // already issued
        User u = findUser(userId);
        if (u == null) return false;              // user doesn't exist

        b.issue();
        issuedMap.put(bookId, userId);
        return true;
    }

    // Return book (only the user who issued can return in this simple model)
    public boolean returnBook(int bookId, int userId) {
        Book b = findBook(bookId);
        if (b == null) return false;              // book doesn't exist
        Integer issuedTo = issuedMap.get(bookId);
        if (issuedTo == null) return false;       // not issued currently
        if (issuedTo != userId) return false;     // issued to different user

        b.returned();
        issuedMap.remove(bookId);
        return true;
    }

    public ArrayList<Book> getAllBooks() { return books; }
    public ArrayList<User> getAllUsers() { return users; }

    // Extra helper: who has a book (returns userId or null)
    public Integer whoHasBook(int bookId) {
        return issuedMap.get(bookId);
    }
}
