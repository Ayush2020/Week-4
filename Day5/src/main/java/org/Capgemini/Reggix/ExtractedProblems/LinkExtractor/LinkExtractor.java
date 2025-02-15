package org.Capgemini.Reggix.ExtractedProblems.LinkExtractor;

import java.util.regex.*;
import java.util.*;

public class LinkExtractor {

    public static List<String> extractLinks(String text) {
        List<String> links = new ArrayList<>();

        // Regular expression to match URLs starting with http:// or https://
        String regex = "\\bhttps?://[a-zA-Z0-9.-]+(?:/[a-zA-Z0-9%&=._-]*)?\\b";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher to find URLs in the input text
        Matcher matcher = pattern.matcher(text);

        // Find all matching links
        while (matcher.find()) {
            links.add(matcher.group());
        }

        return links;
    }

    public static void main(String[] args) {
        // Example text
        String text = "Visit https://www.google.com and http://example.org for more info.";

        // Extract links
        List<String> links = extractLinks(text);

        // Print extracted links
        for (String link : links) {
            System.out.println(link);
        }
    }
}

