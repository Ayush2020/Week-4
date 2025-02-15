package org.Capgemini.Reggix.Advanced.RepeatingWords;

import java.util.HashMap;
import java.util.Map;

public class RepeatingWords {
    public static void main(String[] args) {
        // Sample input
        String sentence = "This is is a repeated repeated word test.";

        // Convert the sentence to lowercase and split it into words
        String[] words = sentence.toLowerCase().split("\\s+");

        // Create a map to store the frequency of each word
        Map<String, Integer> wordCount = new HashMap<>();

        // Loop through the words and count their occurrences
        for (String word : words) {
            word = word.replaceAll("[^a-zA-Z]", ""); // Remove punctuation
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Print out the repeating words
        System.out.println("Repeating words:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.print(entry.getKey() + ", ");
            }
        }
    }
}
