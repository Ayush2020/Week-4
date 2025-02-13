package org.Capgemini.JavaCollections.QueueInterface.Problem2BinaryNumberGenerator;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryNumberGenerator {

    // Method to generate the first N binary numbers using a queue
    public static void generateBinaryNumbers(int N) {
        // Create a queue to store the binary numbers
        Queue<String> queue = new LinkedList<>();

        // Start with the binary number "1"
        queue.add("1");

        // To store the binary numbers generated
        System.out.println("First " + N + " binary numbers:");

        // Generate N binary numbers
        for (int i = 0; i < N; i++) {
            // Dequeue the front element (binary number)
            String binary = queue.poll();

            // Print the current binary number
            System.out.print(binary + " ");

            // Enqueue the next two binary numbers: append '0' and '1' to the current number
            queue.add(binary + "0");
            queue.add(binary + "1");
        }
    }

    public static void main(String[] args) {
        int N = 5;  // Number of binary numbers to generate
        generateBinaryNumbers(N);
    }
}


