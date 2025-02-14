package org.Capgemini.JavaStreams.FilterStreams;

import java.io.*;

public class FilterStreams {

    // Method to read the input file, convert to lowercase, and write to output file
    public static void convertToLowercase(String inputFile, String outputFile) {
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            // Step 1: Initialize BufferedReader to read the input file
            reader = new BufferedReader(new FileReader(inputFile));

            // Step 2: Initialize BufferedWriter to write to the output file
            writer = new BufferedWriter(new FileWriter(outputFile));

            String line;

            // Step 3: Read the file line by line
            while ((line = reader.readLine()) != null) {
                // Step 4: Convert the entire line to lowercase
                String lowerCaseLine = line.toLowerCase();

                // Step 5: Write the lowercase line to the output file
                writer.write(lowerCaseLine);
                writer.newLine(); // To ensure each line is written on a new line
            }

            System.out.println("File content converted to lowercase successfully!");

        } catch (IOException e) {
            System.out.println("An error occurred during file processing: " + e.getMessage());
        } finally {
            // Close the BufferedReader and BufferedWriter
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        // Input and output file paths
        String inputFile = "D:/IntelliC/Week4/Day3/src/main/java/org/Capgemini/JavaStreams/FilterStreams/input.txt";
        String outputFile = "D:/IntelliC/Week4/Day3/src/main/java/org/Capgemini/JavaStreams/FilterStreams/output.txt";

        // Call the method to process the file
        convertToLowercase(inputFile, outputFile);
    }
}

