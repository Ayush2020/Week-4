package org.Capgemini.JavaStreams.ReadAndWriteTextFile;

import java.io.*;

public class ReadAndWriteTextFile {

    public static void main(String[] args) {
        // Define the source and destination file paths
        String sourceFile = "D:/IntelliC/Week4/Day3/src/main/java/org/Capgemini/JavaStreams/ReadAndWriteTextFile/source.txt";
        String destinationFile = "D:/IntelliC/Week4/Day3/src/main/java/org/Capgemini/JavaStreams/ReadAndWriteTextFile/destination.txt";

        // Create FileInputStream and FileOutputStream objects
        FileInputStream fis = null;
        FileOutputStream fos = null;


        try {
            // Initialize FileInputStream to read the source file
            File source = new File(sourceFile);
            if (!source.exists()) {
                System.out.println("Source file does not exist.");
                return; // Exit the program if the source file doesn't exist
            }

            fis = new FileInputStream(source);
            fos = new FileOutputStream(destinationFile);

            int byteData;
            // Read data from the source file and write to the destination file
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            System.out.println("File copied successfully!");
        } catch (IOException e) {
            // Handle IOExceptions (e.g., file not found, read/write error)
            System.out.println("An error occurred while processing the files.");
            e.printStackTrace();
        } finally {
            try {
                // Close the file streams if they are not null
                if (fis != null) {
                    fis.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing the file streams.");
                e.printStackTrace();
            }
        }
    }
}

