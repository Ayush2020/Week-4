package org.Capgemini.Exceptions.ExceptionPropagation;

public class InterestCalculator {

    // Method to calculate interest
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        // Validate input values
        if (amount < 0 || rate < 0) {
            // Throw IllegalArgumentException if amount or rate is negative
            throw new IllegalArgumentException("Amount and rate must be positive");
        }

        // Calculate interest if inputs are valid
        return amount * rate * years / 100;
    }

    public static void main(String[] args) {
        try {
            // Valid input values
            double interest = calculateInterest(1000, 5, 2); // Expected output: 100.0
            System.out.println("Calculated Interest: " + interest);

            // Invalid input values (negative amount)
            interest = calculateInterest(-1000, 5, 2); // This will throw IllegalArgumentException
            System.out.println("Calculated Interest: " + interest);

        } catch (IllegalArgumentException e) {
            // Catch and handle the exception
            System.out.println("Invalid input: " + e.getMessage());
        }
    }
}
