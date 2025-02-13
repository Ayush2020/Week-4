package org.Capgemini.JavaCollections.QueueInterface.Problem5CircularBufferSimulation;

import java.util.LinkedList;
import java.util.Queue;

public class CircularBufferSimulation {
    public static void main(String[] args) {
        // Define the maximum size of the buffer
        int bufferSize = 3;

        // Create a Queue to simulate the circular buffer using LinkedList
        Queue<Integer> q = new LinkedList<>();

        // Insert elements into the queue (the buffer)
        q.offer(1);  // Insert 1
        q.offer(2);  // Insert 2
        q.offer(3);  // Insert 3

        // Print the buffer state after initial inserts
        System.out.println(q);  // Output: [1, 2, 3]

        // Check if the buffer has reached its maximum size (full)
        if (q.size() == bufferSize) {
            // If the buffer is full, remove the oldest element (front of the queue)
            q.poll();  // This removes the element 1 (oldest)
        }

        // Insert a new element into the buffer (which will overwrite the oldest one)
        q.offer(4);  // Insert 4

        // Print the buffer state after inserting 4
        System.out.println(q);  // Output: [2, 3, 4]
    }
}
