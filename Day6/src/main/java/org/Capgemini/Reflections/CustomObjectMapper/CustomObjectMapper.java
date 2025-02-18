package org.Capgemini.Reflections.CustomObjectMapper;

import java.lang.reflect.Field;
import java.util.Map;

public class CustomObjectMapper {

    // Method to convert a Map to an object using reflection
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            // Create a new instance of the class
            T instance = clazz.getDeclaredConstructor().newInstance();

            // Iterate over the properties map to set fields in the instance
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                String fieldName = entry.getKey();
                Object value = entry.getValue();

                // Get the field in the class by name
                Field field = clazz.getDeclaredField(fieldName);

                // Make the field accessible in case it's private or protected
                field.setAccessible(true);

                // Set the field value
                field.set(instance, value);
            }

            return instance;

        } catch (Exception e) {
            // Handle exceptions like NoSuchFieldException or IllegalAccessException
            e.printStackTrace();
        }
        return null;
    }

    // Test class with some fields
    public static class Student {
        private String name;
        private int age;
        private double grade;

        @Override
        public String toString() {
            return "Student{name='" + name + "', age=" + age + ", grade=" + grade + "}";
        }
    }

    public static void main(String[] args) {
        // Example map of properties to set
        Map<String, Object> properties = Map.of(
                "name", "John Doe",
                "age", 21,
                "grade", 88.5
        );

        // Convert the map to a Student object using reflection
        Student student = toObject(Student.class, properties);

        // Print the created object
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Object creation failed.");
        }
    }
}
