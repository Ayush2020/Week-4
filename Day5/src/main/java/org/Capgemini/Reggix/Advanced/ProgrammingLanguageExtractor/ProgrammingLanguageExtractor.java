package org.Capgemini.Reggix.Advanced.ProgrammingLanguageExtractor;

import java.util.*;
import java.util.regex.*;

public class ProgrammingLanguageExtractor {

    public static List<String> extractProgrammingLanguages(String text) {
        // Define a list of common programming languages
        String[] languages = {"Java", "Python", "JavaScript", "Go", "C", "C++", "Ruby", "Swift", "PHP", "Kotlin", "TypeScript"};

        // Create a pattern to match language names in the text
        List<String> foundLanguages = new ArrayList<>();
        for (String language : languages) {
            Pattern pattern = Pattern.compile("\\b" + language + "\\b");
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                foundLanguages.add(language);
            }
        }

        return foundLanguages;
    }

    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        List<String> programmingLanguages = extractProgrammingLanguages(text);

        System.out.println("Extracted Programming Languages: " + String.join(", ", programmingLanguages));
    }
}
