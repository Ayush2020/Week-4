package org.Capgemini.Exceptions.TryWithResources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {

    public static void main(String[] args) {
        // Try-with-resources to automatically close the BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader("D:/IntelliC/Week4/Day4/src/main/java/org/Capgemini/Exceptions/TryWithResources/info.txt"))) {
            // Reading the first line from the file
            String firstLine = reader.readLine();

            // If file is not empty, print the first line
            if (firstLine != null) {
                System.out.println("First line of the file: " + firstLine);
            } else {
                System.out.println("The file is empty.");
            }
        } catch (IOException e) {
            // Catch and handle IOException (e.g., file not found)
            System.out.println("Error reading file");
        }
    }
}
