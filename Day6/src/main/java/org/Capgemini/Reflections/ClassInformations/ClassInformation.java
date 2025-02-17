package org.Capgemini.Reflections.ClassInformations;

import java.lang.reflect.*;

public class ClassInformation {
    public static void main(String[] args) {
        try {
            // Take class name as input
            System.out.print("Enter class name (e.g., java.util.ArrayList): ");
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            String className = scanner.nextLine();
            scanner.close();

            // Load the class using reflection
            Class<?> cls = Class.forName(className);

            // Display class name
            System.out.println("\nClass Name: " + cls.getName());

            // Display Fields
            System.out.println("\nFields:");
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(" - " + field.getName() + " (Type: " + field.getType() + ")");
            }

            // Display Constructors
            System.out.println("\nConstructors:");
            Constructor<?>[] constructors = cls.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(" - " + constructor.getName() + " (Parameters: " + constructor.getParameterCount() + ")");
            }

            // Display Methods
            System.out.println("\nMethods:");
            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(" - " + method.getName() + " (Return Type: " + method.getReturnType() + ", Parameters: " + method.getParameterCount() + ")");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }
}
