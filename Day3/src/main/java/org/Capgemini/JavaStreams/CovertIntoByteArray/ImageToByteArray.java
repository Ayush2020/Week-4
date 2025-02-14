package org.Capgemini.JavaStreams.CovertIntoByteArray;

import java.io.*;

public class ImageToByteArray {

    // Method to convert the image to a byte array and save it to a new file
    public static void convertImageToByteArray(String inputImagePath, String outputImagePath) {
        try {
            // Step 1: Read the image file into a byte array
            File inputFile = new File(inputImagePath);
            FileInputStream fileInputStream = new FileInputStream(inputFile);

            // Create a byte array buffer to store the image data
            byte[] imageBytes = new byte[(int) inputFile.length()];
            fileInputStream.read(imageBytes);
            fileInputStream.close();

            // Step 2: Convert byte array into ByteArrayInputStream (simulating image reading)
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(imageBytes);

            // Step 3: Write the byte array back to a new image file
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int byteData;
            while ((byteData = byteArrayInputStream.read()) != -1) {
                byteArrayOutputStream.write(byteData);
            }

            // Step 4: Save the byte array to a new image file
            FileOutputStream fileOutputStream = new FileOutputStream(outputImagePath);
            byteArrayOutputStream.writeTo(fileOutputStream);
            fileOutputStream.close();
            byteArrayInputStream.close();
            byteArrayOutputStream.close();

            System.out.println("Image copied successfully to: " + outputImagePath);

        } catch (IOException e) {
            System.out.println("An error occurred during image conversion: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Input image file path
        String inputImagePath = "/D:/New/21593.jpg/";
        // Output image file path (new file)
        String outputImagePath = "D:/IntelliC/Week4/Day3/src/main/java/org/Capgemini/JavaStreams/CovertIntoByteArray/output.jpg";

        // Convert the image to a byte array and write it to a new image file
        convertImageToByteArray(inputImagePath, outputImagePath);
    }
}
