# 🧩 Task 08 – Online Quiz App

### 🎯 Objective  
Create a **console-based quiz application** using Java that tests user knowledge with multiple-choice questions and displays a final score.

---

## ⚙️ Tools & Technologies  
- **Java 17+**  
- **VS Code / IntelliJ CE / Eclipse**  
- **Console (Command Prompt / Terminal)**  

---

## 🏗️ Project Structure  

```
Task-08-Online_Quiz_App/
│
├── src/
│ └── quizapp/
│ ├── Question.java # Class representing each quiz question
│ └── QuizApp.java # Main application logic
│
├── out/ # Compiled .class files
│
└── README.md # Project documentation
```


---

## 📘 Features  
- 🧠 Multiple-choice quiz with four options per question  
- ✅ Real-time feedback for correct/incorrect answers  
- 🧾 Final score display with performance message  
- ♻️ Uses **OOP principles** (Question class, encapsulation)  
- ⚙️ Demonstrates **control flow** (loops, conditions, user input)  

---

## ▶️ How to Run  

### 1. Compile the program  
```bash
javac -d out src/quizapp/*.java

java -cp out quizapp.QuizApp
```

## 📊 Sample Output
```
=== 🧩 Welcome to the Java Quiz! ===

Question 1:

Which company developed Java?
1. Microsoft
2. Sun Microsystems
3. Apple
4. Oracle
Enter your answer (1-4): 2
✅ Correct!

Question 2:
Which of these is not a Java feature?
1. Object-oriented
2. Use of pointers
3. Portable
4. Robust
Enter your answer (1-4): 2
✅ Correct!

🎯 Quiz Completed!
Your Score: 2/2
🏆 Excellent! You got all correct!
```
---
## 🧠 Outcome

- This project demonstrates your ability to:

- Apply control flow using if-else and loops.
- Implement logical operations for scoring and feedback.
- Use OOP design with class-based question handling.
- Build an interactive, real-world console application.
---
