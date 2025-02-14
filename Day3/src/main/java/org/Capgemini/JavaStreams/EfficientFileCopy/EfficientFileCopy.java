package org.Capgemini.JavaStreams.EfficientFileCopy;

import java.io.*;
import java.util.*;

public class EfficientFileCopy {

    // Method to copy a file using Buffered Streams
    public static void copyFileBuffered(String sourceFilePath, String destinationFilePath) throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFilePath));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFilePath))) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        }
    }

    // Method to copy a file using Unbuffered Streams
    public static void copyFileUnbuffered(String sourceFilePath, String destinationFilePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(sourceFilePath);
             FileOutputStream fos = new FileOutputStream(destinationFilePath)) {

            int byteRead;
            while ((byteRead = fis.read()) != -1) {
                fos.write(byteRead);
            }
        }
    }

    public static void main(String[] args) {
        // Define the source and destination file paths
        String sourceFile = "D:/IntelliC/Week4/Day3/src/main/java/org/Capgemini/JavaStreams/EfficientFileCopy/source.txt";
        String destinationFileBuffered = "D:/IntelliC/Week4/Day3/src/main/java/org/Capgemini/JavaStreams/EfficientFileCopy/destination.txt";
        String destinationFileUnbuffered = "D:/IntelliC/Week4/Day3/src/main/java/org/Capgemini/JavaStreams/EfficientFileCopy/destination2Buffered.txt";

        // Measure time for Buffered File Copy
        long startTimeBuffered = System.nanoTime();
        try {
            copyFileBuffered(sourceFile, destinationFileBuffered);
        } catch (IOException e) {
            System.out.println("Error during buffered file copy: " + e.getMessage());
        }
        long endTimeBuffered = System.nanoTime();
        long durationBuffered = endTimeBuffered - startTimeBuffered;

        // Measure time for Unbuffered File Copy
        long startTimeUnbuffered = System.nanoTime();
        try {
            copyFileUnbuffered(sourceFile, destinationFileUnbuffered);
        } catch (IOException e) {
            System.out.println("Error during unbuffered file copy: " + e.getMessage());
        }
        long endTimeUnbuffered = System.nanoTime();
        long durationUnbuffered = endTimeUnbuffered - startTimeUnbuffered;

        // Display the performance results
        System.out.println("Buffered Stream copy took: " + durationBuffered + " nanoseconds");
        System.out.println("Unbuffered Stream copy took: " + durationUnbuffered + " nanoseconds");

        // Compare performance
        if (durationBuffered < durationUnbuffered) {
            System.out.println("Buffered stream is faster than unbuffered stream.");
        } else {
            System.out.println("Unbuffered stream is faster than buffered stream.");
        }
    }
}

