package org.Capgemini.JavaCollections.QueueInterface.Problem4StackUsingQueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    // Two queues are used to simulate stack behavior
    private Queue<Integer> queue;  // Main queue to store elements
    private Queue<Integer> queue2; // Temporary queue for rearranging elements during pop/top operations

    // Constructor to initialize the two queues
    public StackUsingQueue() {
        queue = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // Push operation: Adds an element to the stack
    public void push(int x) {
        // Enqueue the element to the main queue
        queue.offer(x);
    }

    // Pop operation: Removes and returns the top element of the stack
    public int pop() {
        // Move all elements except the last one from queue to queue2
        while (queue.size() > 1) {
            queue2.offer(queue.poll());
        }

        // The last element in queue is the top of the stack, remove and return it
        int topElememt = queue.poll();

        // Swap the queues to restore the elements to queue
        Queue<Integer> tempQueue = queue;
        queue = queue2;
        queue2 = tempQueue;

        // Return the top element
        return topElememt;
    }

    // Top operation: Returns the top element without removing it
    public int top() {
        // Move all elements except the last one from queue to queue2
        while (queue.size() > 1) {
            queue2.offer(queue.poll());
        }

        // The last element in queue is the top of the stack, peek at it
        int topElememt = queue.peek();

        // Move the top element back to queue2 to preserve the stack order
        queue2.offer(queue.poll());

        // Swap the queues to restore the elements to queue
        Queue<Integer> tempQueue = queue;
        queue = queue2;
        queue2 = tempQueue;

        // Return the top element
        return topElememt;
    }

    // Empty operation: Checks if the stack is empty
    public boolean empty() {
        // Return true if the main queue is empty, otherwise false
        return queue.isEmpty();
    }

    // Main method to test the stack implementation using two queues
    public static void main(String[] args) {
        // Create a new instance of the StackUsingQueue class
        StackUsingQueue stack = new StackUsingQueue();

        // Push elements onto the stack
        stack.push(1);  // Push 1
        stack.push(2);  // Push 2
        stack.push(3);  // Push 3

        // Perform pop operation and print the result (should return 3)
        System.out.println(stack.pop());  // Output: 3
    }
}
