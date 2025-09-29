package bankapp;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private ArrayList<String> transactionHistory;
    private final DecimalFormat df = new DecimalFormat("#,###.00");


    public Account(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: " + initialBalance);
    }

    // Getters
    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolderName() { return accountHolderName; }
    public double getBalance() { return balance; }
    public ArrayList<String> getTransactionHistoryList() { return transactionHistory; }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + df.format(amount) +
                               " | Balance: " + df.format(balance));
            System.out.println("Deposit successful. New Balance: " + df.format(balance));
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: " + df.format(amount) +
                               " | Balance: " + df.format(balance));
            System.out.println("Withdrawal successful. New Balance: " + df.format(balance));
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds!");
        }
    }

    public void printTransactionHistory() {
    System.out.println("--- Transaction History for " + accountHolderName + " ---");
    for (String record : transactionHistory) {
        System.out.println(record);
    }
}
}
