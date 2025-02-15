package org.Capgemini.Reggix.ReplaceAndModifyStrings.CensorBadWords;

import java.util.*;

public class BadWordReplacer {

    public static String replaceBadWords(String input, List<String> badWords) {
        // Iterate over the list of bad words and replace them with ****
        for (String badWord : badWords) {
            input = input.replaceAll("(?i)\\b" + badWord + "\\b", "****");
        }
        return input;
    }

    public static void main(String[] args) {
        // Example input text
        String input = "This is a damn bad example with some stupid words.";

        // List of bad words
        List<String> badWords = Arrays.asList("damn", "stupid");

        // Replace bad words in the input
        String output = replaceBadWords(input, badWords);

        // Print the result
        System.out.println(output);
    }
}
