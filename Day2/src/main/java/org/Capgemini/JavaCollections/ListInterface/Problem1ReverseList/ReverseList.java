package org.Capgemini.JavaCollections.ListInterface.Problem1ReverseList;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class ReverseList {

    // Generic method to reverse a List using two pointers
    public static <T> void reverseList(List<T> list,int start, int end) {


        // Loop until the two pointers meet or cross each other
        while (start < end) {
            // Swap elements at the start and end indices
            T temp = list.get(start);        // Store the element at the start index in a temporary variable
            list.set(start, list.get(end));  // Replace the start element with the end element
            list.set(end, temp);            // Replace the end element with the temporary variable (original start element)
            
            // Move the pointers toward the center
            start++;                        // Increment the start pointer
            end--;                          // Decrement the end pointer
        }
    }

    public static void main(String[] args) {
        // Example with ArrayList
        List<Integer> arrayList = new ArrayList<>(); // Create an ArrayList
        arrayList.add(1); // Add elements to the ArrayList
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);

        System.out.println("Original Array List: " + arrayList); // Print the original ArrayList
        reverseList(arrayList,0, arrayList.size() -1); // Reverse the ArrayList
        System.out.println("Reversed Array List: " + arrayList); // Print the reversed ArrayList

        // Example with LinkedList
        List<Integer> linkedList = new LinkedList<>(); // Create a LinkedList
        linkedList.add(1); // Add elements to the LinkedList
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);

        System.out.println("Original Linked List: " + linkedList); // Print the original LinkedList
        reverseList(linkedList, 0, linkedList.size() -1 ); // Reverse the LinkedList
        System.out.println("Reversed Linked List: " + linkedList); // Print the reversed LinkedList
    }
}
