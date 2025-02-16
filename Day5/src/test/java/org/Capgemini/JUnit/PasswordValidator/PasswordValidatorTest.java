package org.Capgemini.JUnit.PasswordValidator;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {

    private PasswordValidator passwordValidator = new PasswordValidator();

    // Test valid passwords
    @Test
    public void testValidPassword() {
        String validPassword1 = "Password1";  // Valid password: 8+ characters, one uppercase letter, and one digit
        assertTrue(passwordValidator.validatePassword(validPassword1), "Password should be valid.");

    }

    // Test invalid passwords (too short)
    @Test
    public void testPasswordTooShort() {
        String shortPassword = "Pwd1";  // Invalid password: less than 8 characters
        assertFalse(passwordValidator.validatePassword(shortPassword), "Password should be invalid due to length.");
    }

    // Test invalid passwords (no uppercase letter)
    @Test
    public void testPasswordNoUppercase() {
        String noUppercasePassword = "password1";  // Invalid password: no uppercase letter
        assertFalse(passwordValidator.validatePassword(noUppercasePassword), "Password should be invalid due to lack of uppercase letter.");
    }

    // Test invalid passwords (no digit)
    @Test
    public void testPasswordNoDigit() {
        String noDigitPassword = "Password";  // Invalid password: no digit
        assertFalse(passwordValidator.validatePassword(noDigitPassword), "Password should be invalid due to lack of digit.");
    }

    // Test invalid passwords (no uppercase letter and no digit)
    @Test
    public void testPasswordNoUppercaseNoDigit() {
        String invalidPassword = "password";  // Invalid password: no uppercase letter and no digit
        assertFalse(passwordValidator.validatePassword(invalidPassword), "Password should be invalid due to lack of uppercase letter and digit.");
    }

    // Test null password
    @Test
    public void testNullPassword() {
        String nullPassword = null;  // Invalid password: null
        assertFalse(passwordValidator.validatePassword(nullPassword), "Password should be invalid when null.");
    }
}
