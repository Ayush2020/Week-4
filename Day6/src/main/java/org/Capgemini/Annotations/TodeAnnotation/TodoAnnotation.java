package org.Capgemini.Annotations.TodeAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class TodoAnnotation {


    // Define the @Todo annotation
    @Target(ElementType.METHOD) // Can be applied to methods
    @Retention(RetentionPolicy.RUNTIME) // Retained at runtime for reflection
    public @interface Todo {
        String task(); // Description of the task
        String assignedTo(); // Developer responsible
        String priority() default "MEDIUM"; // Default priority is "MEDIUM"
    }

    // Class with methods annotated with @Todo
    public static class Project {

        @Todo(task = "Implement user authentication", assignedTo = "Alice", priority = "HIGH")
        public void userAuthentication() {
            // Method body
        }

        @Todo(task = "Create database schema", assignedTo = "Bob")
        public void databaseSchema() {
            // Method body
        }

        @Todo(task = "Design UI layout", assignedTo = "Charlie", priority = "LOW")
        public void uiDesign() {
            // Method body
        }

        public void completedTask() {
            // Completed task (no @Todo annotation)
        }
    }

    // Main method to reflect and print all pending tasks
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Project.class;

        // Get all methods of the Project class
        Method[] methods = clazz.getDeclaredMethods();

        // Loop through the methods and check for the Todo annotation
        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Task: " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
                System.out.println("Method: " + method.getName());
                System.out.println("--------------------------------------");
            }
        }
    }
}
