package org.Capgemini.JUnit.Calculator;

public class Calculator {

    // Add two numbers
    public int add(int a, int b) {
        return a + b;
    }

    // Subtract two numbers
    public int subtract(int a, int b) {
        return a - b;
    }

    // Multiply two numbers
    public int multiply(int a, int b) {
        return a * b;
    }

    // Divide two numbers, handle division by zero
    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return (double) a / b;
    }

    // Main method for manual testing
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        // Test Addition
        System.out.println("Addition (5 + 5): " + calc.add(5, 5));

        // Test Subtraction
        System.out.println("Subtraction (10 - 3): " + calc.subtract(10, 3));

        // Test Multiplication
        System.out.println("Multiplication (4 * 5): " + calc.multiply(4, 5));

        // Test Division
        try {
            System.out.println("Division (10 / 2): " + calc.divide(10, 2));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        // Test Division by Zero
        try {
            System.out.println("Division (10 / 0): " + calc.divide(10, 0));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}

