package org.Capgemini.Reflections.DynamicMethodInvited;


import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    // Add method
    public int add(int a, int b) {
        return a + b;
    }

    // Subtract method
    public int subtract(int a, int b) {
        return a - b;
    }

    // Multiply method
    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicMethodInvocation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an instance of MathOperations
        MathOperations mathOperations = new MathOperations();

        // Input for the operation and numbers
        System.out.println("Enter the operation (add, subtract, multiply): ");
        String operation = scanner.nextLine();

        System.out.println("Enter the first number: ");
        int num1 = scanner.nextInt();

        System.out.println("Enter the second number: ");
        int num2 = scanner.nextInt();

        try {
            // Get the class object of MathOperations
            Class<?> clazz = MathOperations.class;

            // Dynamically get the method based on user input
            Method method = clazz.getMethod(operation, int.class, int.class);

            // Dynamically invoke the method
            Object result = method.invoke(mathOperations, num1, num2);

            // Print the result
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
