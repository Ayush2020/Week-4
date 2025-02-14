package org.Capgemini.Exceptions.NestedTryCatch;

import java.util.Scanner;

public class NestedTryCatch {

    public static void main(String[] args) {
        // Initialize a scanner for user input
        Scanner sc = new Scanner(System.in);

        // Sample array
        int[] arr = {10, 20, 30, 40, 50};

        try {
            // Input for array index
            System.out.print("Enter array index: ");
            int index = sc.nextInt();

            // Nested try-catch block for dividing the array element by the divisor
            try {
                // Try accessing the element at the given index
                int value = arr[index];
                // Input for the divisor
                System.out.print("Enter divisor: ");
                int divisor = sc.nextInt();

                // Try dividing the element by the divisor
                int result = value / divisor;
                System.out.println("Division result: " + result);

            } catch (ArithmeticException e) {
                // Handle division by zero
                System.out.println("Cannot divide by zero!");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            // Handle invalid index
            System.out.println("Invalid array index!");
        }

    }
}
