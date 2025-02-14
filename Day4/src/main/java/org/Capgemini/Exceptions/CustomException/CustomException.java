package org.Capgemini.Exceptions.CustomException;

import java.util.Scanner;

// Step 1: Create the custom exception class
class InvalidAgeException extends Exception {
    // Constructor to pass the custom error message
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomException {

    // Step 2: Method to validate age
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            // Throw the custom exception if age is below 18
            throw new InvalidAgeException("Age must be 18 or above.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input for age
        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        // Step 3: Call validateAge and handle the exception
        try {
            // Validate age
            validateAge(age);
            System.out.println("Access granted!"); // If no exception is thrown
        } catch (InvalidAgeException e) {
            // Catch and handle the custom exception
            System.out.println(e.getMessage()); // Display the exception message
        }
    }
}