package org.Capgemini.Exceptions.MultipleCatchBlocks;

import java.util.Scanner;

public class ArrayOperationWithMultipleCatch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Accept input from the user for array size
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        // Initialize the array
        int[] array = new int[size];

        // Accept values to fill the array
        System.out.println("Enter " + size + " integers to populate the array:");
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        // Accept the index number
        System.out.print("Enter the index number to retrieve the value: ");
        int index = sc.nextInt();

        try {
            // Attempt to retrieve the value at the specified index
            System.out.println("Value at index " + index + ": " + array[index]);
        }
        // Catch ArrayIndexOutOfBoundsException if the index is invalid
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");  // Handle invalid index scenario
        }
        // Catch NullPointerException if the array is not initialized
        catch (NullPointerException e) {
            System.out.println("Array is not initialized!");  // Handle null array scenario
        }
        // General exception handler (optional)
        catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
