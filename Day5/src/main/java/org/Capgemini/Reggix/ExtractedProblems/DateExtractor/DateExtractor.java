package org.Capgemini.Reggix.ExtractedProblems.DateExtractor;

import java.util.regex.*;
import java.util.*;

public class DateExtractor {

    public static List<String> extractDates(String text) {
        List<String> dates = new ArrayList<>();

        // Regular expression to match dates in dd/mm/yyyy format
        String regex = "\\b\\d{2}/\\d{2}/\\d{4}\\b";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher to find dates in the input text
        Matcher matcher = pattern.matcher(text);

        // Find all matching dates
        while (matcher.find()) {
            dates.add(matcher.group());
        }

        return dates;
    }

    public static void main(String[] args) {
        // Example text
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";

        // Extract dates
        List<String> dates = extractDates(text);

        // Print extracted dates
        for (String date : dates) {
            System.out.println(date);
        }
    }
}
