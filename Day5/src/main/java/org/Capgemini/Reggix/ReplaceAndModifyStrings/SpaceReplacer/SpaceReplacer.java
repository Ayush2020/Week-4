package org.Capgemini.Reggix.ReplaceAndModifyStrings.SpaceReplacer;

public class SpaceReplacer {

    public static String replaceMultipleSpaces(String input) {
        // Replace multiple spaces with a single space
        return input.replaceAll("\\s+", " ");
    }

    public static void main(String[] args) {
        // Example input
        String input = "This   is  an  example   with  multiple   spaces.";

        // Replace multiple spaces
        String output = replaceMultipleSpaces(input);

        // Print the result
        System.out.println(output);
    }
}
