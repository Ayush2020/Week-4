package org.Capgemini.Exceptions.UnCheckedException;

import java.util.Scanner;
import java.util.InputMismatchException;

public class UnCheckedException {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Prompt the user to enter two numbers
            System.out.print("Enter the numerator: ");
            int numerator = sc.nextInt();

            System.out.print("Enter the denominator: ");
            int denominator = sc.nextInt();

            // Perform division and print the result
            int result = numerator / denominator;
            System.out.println("Result: " + result);

        } catch (InputMismatchException e) {
            // Handle non-numeric input
            System.out.println("Error: Please enter valid integers.");
        } catch (ArithmeticException e) {
            // Handle division by zero
            System.out.println("Error: Division by zero is not allowed.");
        }
    }
}
