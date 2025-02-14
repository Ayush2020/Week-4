package org.Capgemini.JavaStreams.ReadIUserIInputFromConsole;

import java.io.*;

public class UserInputToFile {

    public static void main(String[] args) {
        // Declare variables for user input
        String name, favoriteProgrammingLanguage;
        int age;

        // Create BufferedReader for reading user input
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Ask the user for their name
            System.out.print("Enter your name: ");
            name = reader.readLine();

            // Ask the user for their age
            System.out.print("Enter your age: ");
            age = Integer.parseInt(reader.readLine());  // Convert age from String to integer

            // Ask the user for their favorite programming language
            System.out.print("Enter your favorite programming language: ");
            favoriteProgrammingLanguage = reader.readLine();

            // Prepare the data to be written to a file
            String data = "Name: " + name + "\nAge: " + age + "\nFavorite Programming Language: " + favoriteProgrammingLanguage;

            // Create FileWriter and BufferedWriter to write to the file
            FileWriter fileWriter = new FileWriter("D:IntelliC/Week4/Day3/src/main/java/org/Capgemini/JavaStreams/ReadIUserIInputFromConsole/UserData.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Write the data to the file
            bufferedWriter.write(data);

            // Close the file writer
            bufferedWriter.close();

            System.out.println("Data has been written to the file successfully.");

        } catch (IOException e) {
            // Handle IOExceptions (e.g., reading or writing errors)
            System.out.println("An error occurred while reading input or writing to the file.");
            e.printStackTrace();
        }
    }
}
