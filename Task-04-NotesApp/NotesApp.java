import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class NotesApp {
    private static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Notes App ---");
            System.out.println("1. Write a Note");
            System.out.println("2. View Notes");
            System.out.println("3. Delete a Note");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> writeNote(sc);
                case 2 -> viewNotes();
                case 3 -> deleteNote(sc);
                case 4 -> {
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    // Write a note to the file
    private static void writeNote(Scanner sc) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            System.out.print("Enter your note: ");
            String note = sc.nextLine();
            bw.write(note);
            bw.newLine();
            System.out.println("Note saved!");
        } catch (IOException e) {
            System.out.println("Error writing note: " + e.getMessage());
        }
    }

    // View all notes
    private static void viewNotes() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No notes found.");
            return;
        }

        System.out.println("\n--- Saved Notes ---");
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            int count = 1;
            while ((line = br.readLine()) != null) {
                System.out.println(count++ + ". " + line);
            }
        } catch (IOException e) {
            System.out.println("Error reading notes: " + e.getMessage());
        }
    }

    // Delete a note
    private static void deleteNote(Scanner sc) {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No notes to delete.");
            return;
        }

        // Read all notes into memory
        ArrayList<String> notes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                notes.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading notes: " + e.getMessage());
            return;
        }

        // Display notes
        if (notes.isEmpty()) {
            System.out.println("No notes to delete.");
            return;
        }
        System.out.println("\n--- Notes ---");
        for (int i = 0; i < notes.size(); i++) {
            System.out.println((i + 1) + ". " + notes.get(i));
        }

        // Get note number to delete
        System.out.print("Enter note number to delete: ");
        int num = sc.nextInt();
        sc.nextLine(); // consume newline

        if (num < 1 || num > notes.size()) {
            System.out.println("Invalid note number.");
            return;
        }

        notes.remove(num - 1);

        // Write remaining notes back to file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String note : notes) {
                bw.write(note);
                bw.newLine();
            }
            System.out.println("Note deleted successfully!");
        } catch (IOException e) {
            System.out.println("Error updating notes: " + e.getMessage());
        }
    }
}
