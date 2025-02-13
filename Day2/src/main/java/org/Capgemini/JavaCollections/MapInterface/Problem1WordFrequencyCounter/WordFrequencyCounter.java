package org.Capgemini.JavaCollections.MapInterface.Problem1WordFrequencyCounter;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        // Path to the input file
        String filePath = "D:/IntelliC/Week4/Day2/src/main/hello.txt";

        // Create a HashMap to store word frequencies
        Map<String, Integer> wordFrequencyMap = new HashMap<>();

        // Read the file and count word frequencies
        try {
            // Create a BufferedReader to read the file
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            // Read each line of the file
            while ((line = reader.readLine()) != null) {
                // Convert the line to lowercase and remove punctuation
                line = line.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "");

                // Split the line into words based on whitespace
                String[] words = line.split("\\s+");

                // Count the frequency of each word
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
                    }
                }
            }

            // Close the file reader
            reader.close();

            // Print the word frequency map
            System.out.println("Word Frequency Count:");
            for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

