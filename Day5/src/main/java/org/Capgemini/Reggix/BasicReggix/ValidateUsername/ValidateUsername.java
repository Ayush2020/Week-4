package org.Capgemini.Reggix.BasicReggix.ValidateUsername;

public class ValidateUsername {

    public static String validateUsername(String username) {
        // Regular expression to check the username validity
        if (username.matches("^[a-zA-Z][a-zA-Z0-9_]{4,14}$")) {
            return "Valid";
        } else {
            return "Invalid";
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(validateUsername("user_123"));  // Valid
        System.out.println(validateUsername("123user"));   // Invalid
        System.out.println(validateUsername("us"));        // Invalid
    }
}
