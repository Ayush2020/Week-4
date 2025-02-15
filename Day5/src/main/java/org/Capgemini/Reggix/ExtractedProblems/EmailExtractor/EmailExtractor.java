package org.Capgemini.Reggix.ExtractedProblems.EmailExtractor;

import java.util.regex.*;
import java.util.*;

public class EmailExtractor {

    public static List<String> extractEmails(String text) {
        List<String> emailList = new ArrayList<>();

        // Regular expression to match email addresses
        String emailPattern = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(emailPattern);

        // Create a matcher to find email addresses in the input text
        Matcher matcher = pattern.matcher(text);

        // Find all matching email addresses
        while (matcher.find()) {
            emailList.add(matcher.group());
        }

        return emailList;
    }

    public static void main(String[] args) {
        // Example text
        String text = "Contact us at support@example.com and info@company.org";

        // Extract emails
        List<String> emails = extractEmails(text);

        // Print extracted emails
        for (String email : emails) {
            System.out.println(email);
        }
    }
}
