package org.Capgemini.JavaCollections.QueueInterface.Problem3HospitalTriageSystem;


import java.util.PriorityQueue;

public class HospitalTriageSystem {
    // Patient class to store information about patients
    static class Patient {
        String name;    // Name of the patient
        int severity;   // Severity level of the patient's condition

        // Constructor to initialize patient details
        public Patient(String name, int severity) {
            this.name = name;
            this.severity = severity;
        }

        // Overriding toString method to display patient information in a readable format
        public String toString() {
            return "Hospital [name: " + name + ", severity: " + severity + "]";
        }
    }

    public static void main(String[] args) {
        // Create a PriorityQueue to manage patients, ordered by severity (higher severity treated first)
        // We use a lambda expression to define the comparator that compares patients based on their severity
        PriorityQueue<Patient> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.severity, p1.severity));

        // Adding patients to the priority queue
        pq.add(new Patient("John", 3));   // Patient "John" with severity 3
        pq.add(new Patient("Alice", 5));  // Patient "Alice" with severity 5
        pq.add(new Patient("Bob", 2));    // Patient "Bob" with severity 2

        // Print the order in which patients will be treated based on severity
        System.out.println("Order of Treatment:");

        // While the priority queue is not empty, process each patient (highest severity first)
        while (!pq.isEmpty()) {
            // Poll the patient with the highest severity and print the patient's details
            System.out.println(pq.poll());
        }
    }
}
