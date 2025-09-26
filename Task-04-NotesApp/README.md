# Task 04 – Java Notes App

## 📌 Overview
This project is a **text-based Notes App** built in Java using **File I/O**.  
It allows users to **write, view, and delete notes** stored in a text file.  
This task helps practice **data persistence**, **file handling**, and basic **CLI application design** in Java.

---

## ⚙️ Features
- 📝 **Write Note** – Add a new note to `notes.txt`.
- 📖 **View Notes** – Display all saved notes with numbering.
- ❌ **Delete Note** – Remove a selected note from the file.
- 🚪 **Exit** – Close the application.

---

## 🛠 Technologies Used
- Java (JDK 17+)
- File I/O (`FileReader`, `FileWriter`, `BufferedReader`, `BufferedWriter`)
- CLI-based interaction using `Scanner`
- ArrayList for temporary note management

---

## 🚀 How to Run

### 1. Compile the program
From the project root:
```bash
javac *.java

java NotesApp
```

--- Notes App ---
1. Write a Note
2. View Notes
3. Delete a Note
4. Exit
Choose an option: 1
Enter your note: Learn Java File I/O
Note saved!

--- Notes App ---
1. Write a Note
2. View Notes
3. Delete a Note
4. Exit
Choose an option: 2

--- Saved Notes ---
1. Learn Java File I/O

--- Notes App ---
1. Write a Note
2. View Notes
3. Delete a Note
4. Exit
Choose an option: 3
Enter note number to delete: 1
Note deleted successfully!
