package org.Capgemini.Exceptions.DivisionWithFinallyBlock;

import java.util.Scanner;

public class DivisionWithFinallyBlock {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Taking input for two integers
            System.out.print("Enter the numerator: ");
            int numerator = sc.nextInt();
            System.out.print("Enter the denominator: ");
            int denominator = sc.nextInt();

            // Perform the division
            int result = numerator / denominator;
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            // Catch divide by zero exception
            System.out.println("Error: Division by zero is not allowed.");
        } finally {
            // This block will always execute
            System.out.println("Operation completed");
        }
    }
}
