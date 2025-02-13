package org.Capgemini.JavaCollections.MapInterface.BankingSystem;

import java.util.*;

public class BankingSystem {

    // HashMap to store account information (Account Number -> Balance)
    private Map<String, Double> accounts = new HashMap<>();

    // TreeMap to store accounts sorted by balance (Balance -> Account Number)
    private Map<Double, String> sortedByBalance = new TreeMap<>();

    // Queue to store withdrawal requests
    private Queue<String> withdrawalQueue = new LinkedList<>();

    // Method to create a new account with an initial balance
    public void createAccount(String accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
        sortedByBalance.put(initialBalance, accountNumber);
        System.out.println("Account created for " + accountNumber + " with balance: " + initialBalance);
    }

    // Method to deposit money into an account
    public void deposit(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double currentBalance = accounts.get(accountNumber);
            double newBalance = currentBalance + amount;
            accounts.put(accountNumber, newBalance);
            // Update the TreeMap
            sortedByBalance.put(newBalance, accountNumber);
            System.out.println("Deposited " + amount + " into account " + accountNumber);
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }

    // Method to withdraw money from an account
    public void withdraw(String accountNumber, double amount) {
        withdrawalQueue.add(accountNumber + ":" + amount);
        System.out.println("Withdrawal request added for " + accountNumber + " for amount: " + amount);
    }

    // Method to process withdrawal requests from the queue
    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            String request = withdrawalQueue.poll();
            String[] requestParts = request.split(":");
            String accountNumber = requestParts[0];
            double amount = Double.parseDouble(requestParts[1]);

            if (accounts.containsKey(accountNumber)) {
                double currentBalance = accounts.get(accountNumber);
                if (currentBalance >= amount) {
                    double newBalance = currentBalance - amount;
                    accounts.put(accountNumber, newBalance);
                    System.out.println("Withdrawal successful from account " + accountNumber + ". Amount: " + amount);
                    // Update TreeMap
                    sortedByBalance.put(newBalance, accountNumber);
                } else {
                    System.out.println("Insufficient funds for account " + accountNumber + ". Withdrawal failed.");
                }
            } else {
                System.out.println("Account not found: " + accountNumber);
            }
        }
    }

    // Method to display all accounts sorted by balance
    public void displaySortedAccounts() {
        System.out.println("\nAccounts sorted by balance:");
        for (Map.Entry<Double, String> entry : sortedByBalance.entrySet()) {
            System.out.println("Account Number: " + entry.getValue() + ", Balance: " + entry.getKey());
        }
    }

    // Main method to demonstrate the banking system
    public static void main(String[] args) {
        BankingSystem bankingSystem = new BankingSystem();

        // Create accounts
        bankingSystem.createAccount("ACC001", 1000.00);
        bankingSystem.createAccount("ACC002", 500.00);
        bankingSystem.createAccount("ACC003", 3000.00);

        // Deposit into accounts
        bankingSystem.deposit("ACC001", 500.00);
        bankingSystem.deposit("ACC002", 200.00);

        // Process withdrawal requests
        bankingSystem.withdraw("ACC001", 200.00);
        bankingSystem.withdraw("ACC003", 500.00);
        bankingSystem.withdraw("ACC002", 700.00);
        bankingSystem.withdraw("ACC003", 2500.00);

        // Process the withdrawal requests from the queue
        bankingSystem.processWithdrawals();

        // Display accounts sorted by balance
        bankingSystem.displaySortedAccounts();
    }
}

