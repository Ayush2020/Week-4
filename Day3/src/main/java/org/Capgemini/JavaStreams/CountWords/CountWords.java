package org.Capgemini.JavaStreams.CountWords;

import java.io.*;
import java.util.*;

public class CountWords{
    public static void main(String[] args) {
        String filePath = "D:/IntelliC/Week4/Day3/src/main/java/org/Capgemini/JavaStreams/CountWords/read.txt"; // Specify the path to the text file
        HashMap<String, Integer> wordCountMap = new HashMap<>();

        // Read the file and count words
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into words, remove punctuation, and convert to lowercase
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", "").split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        }

        // Sort the words by frequency in descending order
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCountMap.entrySet());
        sortedList.sort((entry1, entry2) -> entry2.getValue() - entry1.getValue());

        // Display the top 5 most frequent words
        System.out.println("Top 5 most frequent words:");
        for (int i = 0; i < Math.min(5, sortedList.size()); i++) {
            Map.Entry<String, Integer> entry = sortedList.get(i);
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
