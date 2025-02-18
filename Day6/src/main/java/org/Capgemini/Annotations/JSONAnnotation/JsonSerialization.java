package org.Capgemini.Annotations.JSONAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Define the @JsonField annotation
@Target(ElementType.FIELD) // Can only be applied to fields
@Retention(RetentionPolicy.RUNTIME) // Retained at runtime for reflection
@interface JsonField {
    String name(); // Custom JSON key name
}

// User class with fields annotated with @JsonField
class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_email")
    private String email;

    @JsonField(name = "user_age")
    private int age;

    public User(String username, String email, int age) {
        this.username = username;
        this.email = email;
        this.age = age;
    }

    // Getters for fields (optional for serialization)
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}

// Main class to convert object to JSON using reflection
public class JsonSerialization {

    
    // Method to convert object to JSON string
    public static String toJson(Object obj) throws IllegalAccessException {
        StringBuilder json = new StringBuilder("{");

        // Get all fields of the class
        Field[] fields = obj.getClass().getDeclaredFields();
        Map<String, String> jsonFields = new HashMap<>();

        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField annotation = field.getAnnotation(JsonField.class);
                String jsonKey = annotation.name();
                field.setAccessible(true); // Make the private field accessible

                // Get the value of the field and add it to the map
                Object value = field.get(obj);
                jsonFields.put(jsonKey, String.valueOf(value));
            }
        }

        // Build JSON string
        for (Map.Entry<String, String> entry : jsonFields.entrySet()) {
            json.append("\"").append(entry.getKey()).append("\": \"").append(entry.getValue()).append("\", ");
        }

        // Remove the last comma and space
        if (json.length() > 1) {
            json.delete(json.length() - 2, json.length());
        }

        json.append("}");

        return json.toString();
    }

    public static void main(String[] args) {
        // Create a User object
        User user = new User("john_doe", "john@example.com", 30);

        try {
            // Convert the User object to JSON string
            String jsonString = toJson(user);
            System.out.println(jsonString);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

