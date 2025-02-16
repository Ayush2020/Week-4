package org.Capgemini.JUnit.UserRegistration;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserRegistrationTest {

    private UserRegistration userRegistration = new UserRegistration();

    // Test valid user registration
    @Test
    public void testValidRegistration() {
        // Valid inputs
        String validUsername = "john_doe";
        String validEmail = "john.doe@example.com";
        String validPassword = "Password123";

        // No exception should be thrown
        assertDoesNotThrow(() -> userRegistration.registerUser(validUsername, validEmail, validPassword));
    }

    // Test invalid username (empty username)
    @Test
    public void testEmptyUsername() {
        String invalidUsername = "";
        String validEmail = "john.doe@example.com";
        String validPassword = "Password123";

        // Expecting IllegalArgumentException due to empty username
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser(invalidUsername, validEmail, validPassword));
    }

    // Test invalid email (invalid email format)
    @Test
    public void testInvalidEmailFormat() {
        String validUsername = "john_doe";
        String invalidEmail = "john.doe.com";  // Invalid email (missing @)
        String validPassword = "Password123";

        // Expecting IllegalArgumentException due to invalid email format
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser(validUsername, invalidEmail, validPassword));
    }

    // Test invalid password (password too short)
    @Test
    public void testShortPassword() {
        String validUsername = "john_doe";
        String validEmail = "john.doe@example.com";
        String shortPassword = "short";  // Password is too short (less than 8 characters)

        // Expecting IllegalArgumentException due to short password
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser(validUsername, validEmail, shortPassword));
    }

    // Test invalid null email
    @Test
    public void testNullEmail() {
        String validUsername = "john_doe";
        String nullEmail = null;
        String validPassword = "Password123";

        // Expecting IllegalArgumentException due to null email
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser(validUsername, nullEmail, validPassword));
    }

    
}
