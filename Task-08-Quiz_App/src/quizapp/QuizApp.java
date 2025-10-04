package quizapp;

import java.util.*;

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Question> questions = new ArrayList<>();

        // Adding questions
        questions.add(new Question(
                "Which company developed Java?",
                Arrays.asList("Microsoft", "Sun Microsystems", "Apple", "Oracle"),
                2
        ));
        questions.add(new Question(
                "Which of these is not a Java feature?",
                Arrays.asList("Object-oriented", "Use of pointers", "Portable", "Robust"),
                2
        ));
        questions.add(new Question(
                "What is the extension of Java bytecode files?",
                Arrays.asList(".java", ".class", ".byte", ".exe"),
                2
        ));
        questions.add(new Question(
                "Which keyword is used to inherit a class in Java?",
                Arrays.asList("this", "super", "extends", "implements"),
                3
        ));

        System.out.println("=== Welcome to the Java Quiz! ===");
        int score = 0;

        for (int i = 0; i < questions.size(); i++) {
            System.out.println("\nQuestion " + (i + 1) + ":");
            questions.get(i).displayQuestion();
            System.out.print("Enter your answer (1-4): ");
            int answer = sc.nextInt();

            if (questions.get(i).checkAnswer(answer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was option " + questions.get(i).checkAnswer(answer));
            }
        }

        System.out.println("\nQuiz Completed!");
        System.out.println("Your Score: " + score + "/" + questions.size());

        if (score == questions.size()) {
            System.out.println("Excellent! You got all correct!");
        } else if (score >= questions.size() / 2) {
            System.out.println("Good Job! Keep learning Java!");
        } else {
            System.out.println("Keep practicing to improve!");
        }

        sc.close();
    }
}
