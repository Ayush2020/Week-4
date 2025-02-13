package org.Capgemini.JavaCollections.QueueInterface.Problem1ReverseQueue;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {

    // Method to reverse the queue using recursion
    public static void reverseQueue(Queue<Integer> queue) {
        // Base case: if the queue is empty, we stop the recursion
        if (queue.isEmpty()){
            return;
        }

        // Step 1: Remove the front element from the queue
        int front = queue.remove();

        // Step 2: Recursively reverse the remaining elements in the queue
        reverseQueue(queue);

        // Step 3: Add the removed element to the back of the queue
        queue.add(front);
    }

    // Method to print the elements of the queue
    public static void printQueue(Queue<Integer> queue) {
        // Iterating through the queue and printing each element
        for (int element : queue) {
            System.out.print(element + " ");
        }
        System.out.println(); // Move to the next line after printing the queue
    }

    public static void main(String[] args) {
        // Creating a queue of integers and adding elements
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1); // Adding element 1
        queue.add(2); // Adding element 2
        queue.add(3); // Adding element 3
        queue.add(4); // Adding element 4

        // Printing the original queue
        System.out.print("Original Queue: ");
        printQueue(queue);

        // Reversing the queue using recursion
        reverseQueue(queue);

        // Printing the reversed queue
        System.out.print("Reversed Queue: ");
        printQueue(queue);
    }
}
