package bankapp;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Bank {
    private HashMap<String, Account> accounts;
    private static final String DATA_FILE = "data/accounts.txt";

    public Bank() {
        accounts = new HashMap<>();
        createDataFolder();
        loadAccounts();
    }

    // Ensure data folder exists
    private void createDataFolder() {
        File folder = new File("data");
        if (!folder.exists()) folder.mkdir();
    }

    // Create account
    public void createAccount(String accountNumber, String holderName, double initialBalance) {
        if (!accounts.containsKey(accountNumber)) {
            Account account = new Account(accountNumber, holderName, initialBalance);
            accounts.put(accountNumber, account);
            saveAccounts(); // save after creation
            System.out.println("Account created successfully!");
        } else {
            System.out.println("Account already exists!");
        }
    }

    // Retrieve account
    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    // List all accounts
    public void listAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            System.out.println("=== All Accounts ===");
            for (Account acc : accounts.values()) {
                System.out.println(acc.getAccountNumber() + " - " + acc.getAccountHolderName() +
                        " | Balance: " + acc.getBalance());
            }
        }
    }

    // Save accounts + transaction history
    public void saveAccounts() {
        DecimalFormat df = new DecimalFormat("#,###.00");
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE))) {
            for (Account acc : accounts.values()) {
                writer.write("Account: " + acc.getAccountNumber());
                writer.newLine();
                writer.write("Holder: " + acc.getAccountHolderName());
                writer.newLine();
                writer.write("Balance: " + df.format(acc.getBalance()));
                writer.newLine();
                writer.write("Transactions:");
                writer.newLine();
                for (String t : acc.getTransactionHistoryList()) {
                    writer.write("  - " + t);
                    writer.newLine();
                }
                writer.write("---------------------------------------");
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving accounts: " + e.getMessage());
        }
    }

    // Load accounts (only balance is restored; transaction history starts fresh)
    private void loadAccounts() {
        File file = new File(DATA_FILE);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;
            String accNum = null;
            String holder = null;
            double balance = 0;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Account: ")) {
                    accNum = line.split(": ")[1];
                } else if (line.startsWith("Holder: ")) {
                    holder = line.split(": ")[1];
                } else if (line.startsWith("Balance: ")) {
                    balance = Double.parseDouble(line.split(": ")[1]);
                } else if (line.startsWith("---------------------------------------")) {
                    if (accNum != null && holder != null) {
                        accounts.put(accNum, new Account(accNum, holder, balance));
                    }
                    accNum = holder = null;
                    balance = 0;
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading accounts: " + e.getMessage());
        }
    }
}
