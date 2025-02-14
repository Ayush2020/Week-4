package org.Capgemini.JavaStreams.DataStreams;

import java.io.*;

class Student {
    private int rollNumber;
    private String name;
    private double gpa;

    // Constructor
    public Student(int rollNumber, String name, double gpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.gpa = gpa;
    }

    // Getters
    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    // Method to display student details
    public void displayStudentDetails() {
        System.out.println("Roll Number: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
    }
}

public class DataStreams {

    // Method to store student details in a binary file
    public static void storeStudentDetails(String fileName, Student student) {
        DataOutputStream dataOutputStream = null;

        try {
            // Create DataOutputStream to write primitive data to file
            dataOutputStream = new DataOutputStream(new FileOutputStream(fileName));

            // Write student details to the file
            dataOutputStream.writeInt(student.getRollNumber());
            dataOutputStream.writeUTF(student.getName());
            dataOutputStream.writeDouble(student.getGpa());

            System.out.println("Student details stored successfully!");

        } catch (IOException e) {
            System.out.println("Error while storing student details: " + e.getMessage());
        } finally {
            // Close the DataOutputStream
            try {
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing the DataOutputStream: " + e.getMessage());
            }
        }
    }

    // Method to retrieve student details from a binary file
    public static void retrieveStudentDetails(String fileName) {
        DataInputStream dataInputStream = null;

        try {
            // Create DataInputStream to read primitive data from file
            dataInputStream = new DataInputStream(new FileInputStream(fileName));

            // Read student details from the file
            int rollNumber = dataInputStream.readInt();
            String name = dataInputStream.readUTF();
            double gpa = dataInputStream.readDouble();

            // Create a student object and display details
            Student student = new Student(rollNumber, name, gpa);
            student.displayStudentDetails();

        } catch (IOException e) {
            System.out.println("Error while retrieving student details: " + e.getMessage());
        } finally {
            // Close the DataInputStream
            try {
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing the DataInputStream: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        String fileName = "D:/IntelliC/Week4/Day3/src/main/java/org/Capgemini/JavaStreams/DataStreams/data.txt";

        // Store student details in the binary file
        Student student = new Student(101, "John Doe", 3.8);
        storeStudentDetails(fileName, student);

        // Retrieve and display student details from the binary file
        retrieveStudentDetails(fileName);
    }
}

