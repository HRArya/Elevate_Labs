import java.util.Scanner;

public class Calculator {

    // Basic operation methods
    public static double add(double a, double b) { return a + b; }
    public static double subtract(double a, double b) { return a - b; }
    public static double multiply(double a, double b) { return a * b; }
    public static Double divide(double a, double b) {
        if (b == 0) return null; // caller will handle division-by-zero
        return a / b;
    }

    // Helper to read a double safely from Scanner (returns null on invalid input)
    private static Double readDouble(Scanner sc) {
        String line = sc.nextLine().trim();
        try {
            return Double.parseDouble(line);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("=== Simple Java Console Calculator ===");
                System.out.println("1) Add");
                System.out.println("2) Subtract");
                System.out.println("3) Multiply");
                System.out.println("4) Divide");
                System.out.println("5) Exit");
                System.out.print("Choose an option (1-5): ");
                String choice = sc.nextLine().trim();

                if (choice.equals("5") || choice.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting. Goodbye!");
                    break;
                }

                if (!choice.matches("[1-4]")) {
                    System.out.println("Invalid choice. Please enter 1-5.\n");
                    continue;
                }

                System.out.print("Enter first number: ");
                Double a = readDouble(sc);
                if (a == null) {
                    System.out.println("Invalid number input. Try again.\n");
                    continue;
                }

                System.out.print("Enter second number: ");
                Double b = readDouble(sc);
                if (b == null) {
                    System.out.println("Invalid number input. Try again.\n");
                    continue;
                }

                double result;
                switch (choice) {
                    case "1": result = add(a, b); break;
                    case "2": result = subtract(a, b); break;
                    case "3": result = multiply(a, b); break;
                    case "4":
                        Double div = divide(a, b);
                        if (div == null) {
                            System.out.println("Error: Division by zero is not allowed.\n");
                            continue;
                        } else {
                            result = div;
                        }
                        break;
                    default:
                        System.out.println("Unexpected error.\n");
                        continue;
                }

                System.out.println("Result: " + result + "\n");
            }
        } // Scanner auto-closed
    }
}
