package org.Capgemini.Reggix.ExtractedProblems.CapitalizeWords;

import java.util.regex.*;
import java.util.*;

public class CapitalizedWordsExtractor {

    public static List<String> extractCapitalizedWords(String text) {
        List<String> capitalizedWords = new ArrayList<>();

        // Regular expression to match words starting with a capital letter
        String regex = "\\b[A-Z][a-z]*\\b";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher to find capitalized words in the input text
        Matcher matcher = pattern.matcher(text);

        // Find all matching capitalized words
        while (matcher.find()) {
            capitalizedWords.add(matcher.group());
        }

        return capitalizedWords;
    }

    public static void main(String[] args) {
        // Example text
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        // Extract capitalized words
        List<String> words = extractCapitalizedWords(text);

        // Print extracted words
        for (String word : words) {
            System.out.println(word);
        }
    }
}
