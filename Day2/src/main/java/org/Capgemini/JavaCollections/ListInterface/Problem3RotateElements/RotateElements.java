package org.Capgemini.JavaCollections.ListInterface.Problem3RotateElements;

import java.util.*;

public class RotateElements {

    // Method to reverse the elements of the list between 'start' and 'end' indices
    public static void rotate(List<Integer> list, int start, int end) {
        // Continue swapping elements until start index is less than the end index
        while (start < end) {
            // Store the element at the 'start' index temporarily
            int temp = list.get(start);

            // Swap the element at 'start' with the element at 'end'
            list.set(start, list.get(end));
            list.set(end, temp);

            // Move 'start' index forward and 'end' index backward to keep reversing
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        // Initialize a list with values
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));

        // Define the number of positions to rotate the list
        int rotate = 2;

        // Reverse the first part of the list (from 0 to rotate-1)
        rotate(list, 0, rotate - 1);  // Reverse first 2 elements (index 0 to 1)

        // Reverse the second part of the list (from rotate to end of the list)
        rotate(list, rotate, list.size() - 1);  // Reverse from index 2 to 4

        // Reverse the entire list (this completes the rotation)
        rotate(list, 0, list.size() - 1);  // Reverse the entire list to get final rotated result

        // Output the rotated list
        System.out.println(list);  // Expected Output: [30, 40, 50, 10, 20]
    }
}
