package org.Capgemini.Exceptions.BankAccountSystem;


// Custom exception to handle insufficient funds during withdrawal
class InSufficientFundsException extends Exception {
    private double amount; // Variable to store the shortfall amount

    // Constructor to initialize the exception message and shortfall amount
    public InSufficientFundsException(String message, double amount) {
        super(message); // Pass the message to the parent Exception class
        this.amount = amount; // Set the shortfall amount
    }

    // Getter method to return the shortfall amount
    public double getAmount() {
        return amount;
    }
}

// BankAccount class to simulate a basic bank account
public class BankAccountSystem {
    private double balance; // The account balance

    // Constructor to initialize the account with a starting balance
    public BankAccountSystem(double balance) {
        this.balance = balance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) { // Ensure that the deposit amount is positive
            this.balance += amount; // Add the deposit amount to the balance
        }
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) throws InSufficientFundsException {
        // Check if the withdrawal amount exceeds the current balance
        if (amount > balance) {
            // If the balance is insufficient, throw the custom exception
            throw new InSufficientFundsException("InSufficient Funds", amount - balance);
        }
        // If sufficient funds are available, deduct the withdrawal amount from the balance
        balance -= amount;
        System.out.println("Withdrawal Successfull!!, New Balance " + balance);
    }

    // Getter method to return the current balance of the account
    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        // Create a new BankAccount object with an initial balance of 100
        BankAccountSystem account = new BankAccountSystem(100);

        try {
            // Deposit 50 into the account
            System.out.println("Depositing 50...");
            account.deposit(50.0);
            // Print the new balance after deposit
            System.out.println("New Balance = " + account.getBalance());

            // Attempt to withdraw 200, which is more than the current balance
            System.out.println("Withdraw 200...");
            account.withdraw(200.0);

        } catch (InSufficientFundsException e) {
            // Catch the exception if there are insufficient funds
            System.out.println("Exception : " + e.getMessage()); // Print the exception message
            System.out.println("ShortFall: " + e.getAmount()); // Print the shortfall amount
        }
    }
}
