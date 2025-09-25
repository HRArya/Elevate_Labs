// LibraryManagement.java
import java.util.Scanner;

public class LibraryManagement {
    private static final Scanner sc = new Scanner(System.in);
    private static final Library library = new Library();

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = readInt("Enter choice: ");
            switch (choice) {
                case 1 -> addBookFlow();
                case 2 -> addUserFlow();
                case 3 -> issueBookFlow();
                case 4 -> returnBookFlow();
                case 5 -> viewBooksFlow();
                case 6 -> viewUsersFlow();
                case 7 -> {
                    System.out.println("Exiting. Goodbye!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
            System.out.println();
        }
    }

    private static void showMenu() {
        System.out.println("=== Library Management System ===");
        System.out.println("1) Add Book");
        System.out.println("2) Add User");
        System.out.println("3) Issue Book");
        System.out.println("4) Return Book");
        System.out.println("5) View Books");
        System.out.println("6) View Users");
        System.out.println("7) Exit");
    }

    private static void addBookFlow() {
        int id = readInt("Enter Book ID: ");
        String title = readLine("Enter Title: ");
        String author = readLine("Enter Author: ");
        Book b = new Book(id, title, author);
        if (library.addBook(b)) System.out.println("Book added successfully.");
        else System.out.println("Book with this ID already exists.");
    }

    private static void addUserFlow() {
        int uid = readInt("Enter User ID: ");
        String name = readLine("Enter User Name: ");
        User u = new User(uid, name);
        if (library.addUser(u)) System.out.println("User added successfully.");
        else System.out.println("User with this ID already exists.");
    }

    private static void issueBookFlow() {
        int bookId = readInt("Enter Book ID to issue: ");
        int userId = readInt("Enter User ID: ");
        boolean ok = library.issueBook(bookId, userId);
        if (ok) System.out.println("Book issued to user successfully.");
        else {
            Book b = library.findBook(bookId);
            if (b == null) System.out.println("Book not found.");
            else if (b.isIssued()) {
                Integer who = library.whoHasBook(bookId);
                System.out.println("Book already issued to UserID: " + who + ".");
            } else {
                System.out.println("User not found or cannot issue book.");
            }
        }
    }

    private static void returnBookFlow() {
        int bookId = readInt("Enter Book ID to return: ");
        int userId = readInt("Enter Your User ID: ");
        boolean ok = library.returnBook(bookId, userId);
        if (ok) System.out.println("Book returned successfully.");
        else System.out.println("Return failed. Either book/user not found, book not issued, or issued to different user.");
    }

    private static void viewBooksFlow() {
        System.out.println("--- Books in Library ---");
        if (library.getAllBooks().isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for (Book b : library.getAllBooks()) System.out.println(b);
    }

    private static void viewUsersFlow() {
        System.out.println("--- Registered Users ---");
        if (library.getAllUsers().isEmpty()) {
            System.out.println("No users registered.");
            return;
        }
        for (User u : library.getAllUsers()) System.out.println(u);
    }

    // Helpers for robust input
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    private static String readLine(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }
}
