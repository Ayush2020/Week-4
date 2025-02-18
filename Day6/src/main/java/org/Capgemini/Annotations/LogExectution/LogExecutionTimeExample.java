package org.Capgemini.Annotations.LogExectution;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class LogExecutionTimeExample {

    // Define the @LogExecutionTime annotation
    @Target(ElementType.METHOD) // Can be applied to methods
    @Retention(RetentionPolicy.RUNTIME) // Retained at runtime for reflection
    public @interface LogExecutionTime {
    }

    // Class with methods annotated with @LogExecutionTime
    public static class ExampleClass {

        @LogExecutionTime
        public void methodOne() {
            try {
                Thread.sleep(500); // Simulate some processing
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @LogExecutionTime
        public void methodTwo() {
            try {
                Thread.sleep(200); // Simulate some processing
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void regularMethod() {
            try {
                Thread.sleep(100); // Simulate some processing
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Main method to measure and log execution time
    public static void main(String[] args) throws Exception {
        Class<?> clazz = ExampleClass.class;
        Object instance = clazz.getDeclaredConstructor().newInstance();

        Method[] methods = clazz.getDeclaredMethods();

        // Loop through methods to find and execute those with @LogExecutionTime annotation
        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long startTime = System.nanoTime();

                // Invoke the method
                method.invoke(instance);

                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                System.out.println("Execution time of " + method.getName() + ": " + duration + " nanoseconds");
            }
        }
    }
}
