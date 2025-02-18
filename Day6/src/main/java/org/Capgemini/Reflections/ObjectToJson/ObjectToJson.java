package org.Capgemini.Reflections.ObjectToJson;

import java.lang.reflect.Field;

public class ObjectToJson {

    // Method to convert an object to a JSON-like string using reflection
    public static String toJson(Object obj) {
        StringBuilder jsonString = new StringBuilder("{");

        // Get all fields (including private and protected)
        Field[] fields = obj.getClass().getDeclaredFields();

        // Iterate over the fields
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true); // Make private fields accessible

            try {
                // Get the value of the field from the object
                Object value = field.get(obj);

                // Convert the field name and value to a JSON string
                jsonString.append("\"").append(field.getName()).append("\": ");

                if (value == null) {
                    jsonString.append("null");
                } else if (value instanceof String) {
                    jsonString.append("\"").append(value).append("\"");
                } else {
                    jsonString.append(value);
                }

                // Add a comma if this is not the last field
                if (i < fields.length - 1) {
                    jsonString.append(", ");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        jsonString.append("}");

        return jsonString.toString();
    }

    // Test class with some fields
    public static class Student {
        private String name;
        private int age;
        private double grade;

        // Constructor
        public Student(String name, int age, double grade) {
            this.name = name;
            this.age = age;
            this.grade = grade;
        }
    }

    public static void main(String[] args) {
        // Create a Student object
        Student student = new Student("John Doe", 21, 88.5);

        // Convert the Student object to a JSON-like string
        String jsonString = toJson(student);

        // Print the JSON-like representation of the object
        System.out.println(jsonString);
    }
}
