package bankapp;

import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        boolean running = true;

        while (running) {
            System.out.println("\n=== Bank Account Simulation ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Transaction History");
            System.out.println("6. List All Accounts");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Account Number: ");
                    String accNum = scanner.nextLine();
                    System.out.print("Enter Holder Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double bal = scanner.nextDouble();
                    bank.createAccount(accNum, name, bal);
                }
                case 2 -> {
                    System.out.print("Enter Account Number: ");
                    String accNum = scanner.nextLine();
                    Account acc = bank.getAccount(accNum);
                    if (acc != null) {
                        System.out.print("Enter Amount to Deposit: ");
                        acc.deposit(scanner.nextDouble());
                        bank.saveAccounts();
                    } else System.out.println("Account not found!");
                }
                case 3 -> {
                    System.out.print("Enter Account Number: ");
                    String accNum = scanner.nextLine();
                    Account acc = bank.getAccount(accNum);
                    if (acc != null) {
                        System.out.print("Enter Amount to Withdraw: ");
                        acc.withdraw(scanner.nextDouble());
                        bank.saveAccounts();
                    } else System.out.println("Account not found!");
                }
                case 4 -> {
                    System.out.print("Enter Account Number: ");
                    String accNum = scanner.nextLine();
                    Account acc = bank.getAccount(accNum);
                    if (acc != null) System.out.println("Balance: " + acc.getBalance());
                    else System.out.println("Account not found!");
                }
                case 5 -> {
                    System.out.print("Enter Account Number: ");
                    String accNum = scanner.nextLine();
                    Account acc = bank.getAccount(accNum);
                    if (acc != null) acc.printTransactionHistory();
                    else System.out.println("Account not found!");
                }
                case 6 -> bank.listAccounts();
                case 7 -> {
                    System.out.println("Exiting Bank App. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid option!");
            }
        }
        scanner.close();
    }
}
