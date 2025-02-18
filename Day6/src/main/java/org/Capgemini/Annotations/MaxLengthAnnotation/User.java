package org.Capgemini.Annotations.MaxLengthAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


// Define the @MaxLength annotation
@Target(ElementType.FIELD) // Can only be applied to fields
@Retention(RetentionPolicy.RUNTIME) // Retained at runtime for reflection
@interface MaxLength {
    int value(); // The maximum allowed length of the string field
}

// User class with validation for username field
public class User {

    @MaxLength(10) // Max length for username is 10 characters
    private String username;

    // Constructor validates the length of the username
    public User(String username) {
        this.username = username;
        validateFields();
    }

    // Validate all fields annotated with @MaxLength
    private void validateFields() {
        for (var field : this.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength annotation = field.getAnnotation(MaxLength.class);
                int maxLength = annotation.value();

                // Check if the length exceeds the max length allowed
                try {
                    field.setAccessible(true); // Make the private field accessible
                    String fieldValue = (String) field.get(this); // Get the value of the field
                    if (fieldValue != null && fieldValue.length() > maxLength) {
                        throw new IllegalArgumentException(
                                "Field '" + field.getName() + "' exceeds the maximum length of " + maxLength + " characters."
                        );
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    public static void main(String[] args) {
        try {
            // Test valid username
            User validUser = new User("shortname");
            System.out.println("Valid user created: " + validUser.getUsername());

            // Test invalid username (throws IllegalArgumentException)
            User invalidUser = new User("thisisaverylongusername");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
