package org.Capgemini.Reggix.Advanced.SSNValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SSNValidator {
    public static void main(String[] args) {
        // Example SSN inputs
        String input1 = "My SSN is 123-45-6789.";
        String input2 = "My SSN is 123456789.";

        // Regular expression for SSN format
        String ssnPattern = "\\b\\d{3}-\\d{2}-\\d{4}\\b"; // Matches the format XXX-XX-XXXX

        // Validate the first SSN
        validateSSN(input1, ssnPattern);

        // Validate the second SSN
        validateSSN(input2, ssnPattern);
    }

    public static void validateSSN(String input, String ssnPattern) {
        // Create a Pattern object
        Pattern pattern = Pattern.compile(ssnPattern);

        // Create matcher object to check input
        Matcher matcher = pattern.matcher(input);

        // Check if the input matches the SSN format
        if (matcher.find()) {
            System.out.println(matcher.group() + "\" is valid.");
        } else {
            System.out.println(input.trim() + "\" is invalid.");
        }
    }
}
