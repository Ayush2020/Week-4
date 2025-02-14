package org.Capgemini.JavaStreams.LargeFileLineByLine;

import java.io.*;

public class LargeFileReader {
    public static void main(String[] args) {
        // Specify the path to the large file
        String filePath = "D:/IntelliC/Week4/Day3/src/main/java/org/Capgemini/JavaStreams/LargeFileLineByLine/new.txt";  // Change this to your file path

        // Open the file for reading
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read the file line by line
            while ((line = br.readLine()) != null) {
                // Check if the line contains "error" (case-insensitive)
                if (line.toLowerCase().contains("matter")) {
                    System.out.println(line);  // Print the matching line
                }
            }
        } catch (IOException e) {
            // Handle any potential IO exceptions
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
