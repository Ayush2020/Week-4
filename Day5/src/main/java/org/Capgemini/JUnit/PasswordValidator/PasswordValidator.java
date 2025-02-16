package org.Capgemini.JUnit.PasswordValidator;

public class PasswordValidator {

    // Method to validate password
    public boolean validatePassword(String password) {
        if (password == null) {
            return false;
        }

        // Check if the password has at least 8 characters
        if (password.length() < 8) {
            return false;
        }

        // Check if the password has at least one uppercase letter
        boolean hasUppercase = false;
        boolean hasDigit = false;

        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                hasUppercase = true;
            }
            if (Character.isDigit(password.charAt(i))) {
                hasDigit = true;
            }
        }

        // The password must contain both an uppercase letter and a digit
        return hasUppercase && hasDigit;
    }
}
