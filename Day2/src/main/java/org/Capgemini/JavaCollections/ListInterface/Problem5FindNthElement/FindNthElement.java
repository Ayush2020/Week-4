package org.Capgemini.JavaCollections.ListInterface.Problem5FindNthElement;
import java.util.LinkedList;

public class FindNthElement {

    // Method to find the Nth element from the end of the list
    public static String Element(LinkedList<String> list, int N) {
        // Get the size of the list
        int size = list.size();

        // Calculate the index of the Nth element from the end
        int index = size - N;

        // Return the element at the calculated index
        return list.get(index);
    }

    public static void main(String[] args) {
        // Create and populate a linked list with some elements
        LinkedList<String> list = new LinkedList<>();
        list.add("A");  // Adding "A" to the list
        list.add("B");  // Adding "B" to the list
        list.add("C");  // Adding "C" to the list
        list.add("D");  // Adding "D" to the list
        list.add("E");  // Adding "E" to the list

        // Define the value of N (the position from the end of the list)
        int N = 2;

        // Call the Element method to get the Nth element from the end and print it
        System.out.println(Element(list, N));  // Expected output: "D"
    }
}

