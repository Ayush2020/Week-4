package org.Capgemini.Exceptions.CheckedException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    public static void main(String[] args) {
        String filePath = "data.txt"; // Specify the file name

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Reading the file line by line
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // Handle the exception if the file doesn't exist or another I/O issue occurs
            System.out.println("File Not found");
        }
    }
    
}

