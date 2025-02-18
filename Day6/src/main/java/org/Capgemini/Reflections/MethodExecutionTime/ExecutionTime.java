package org.Capgemini.Reflections.MethodExecutionTime;

import java.lang.reflect.Method;

public class ExecutionTime {

    // Method to measure execution time of methods dynamically using reflection
    public static void measureExecutionTime(Class<?> clazz, String methodName, Object... params) throws Exception {
        // Get the method with the given name and parameters
        Method method = clazz.getDeclaredMethod(methodName, toClassArray(params));

        // Make the method accessible if it's private or protected
        method.setAccessible(true);

        // Measure the start time
        long startTime = System.nanoTime();

        // Invoke the method with the given parameters
        method.invoke(clazz.getDeclaredConstructor().newInstance(), params);

        // Measure the end time
        long endTime = System.nanoTime();

        // Calculate and print the execution time
        long duration = endTime - startTime;
        System.out.println("Execution time of " + methodName + ": " + duration + " nanoseconds");
    }

    // Utility method to convert Object array to Class array
    private static Class<?>[] toClassArray(Object[] params) {
        Class<?>[] classArray = new Class<?>[params.length];
        for (int i = 0; i < params.length; i++) {
            classArray[i] = params[i].getClass();
        }
        return classArray;
    }

    // Example class with methods to measure
    public static class ExampleClass {
        public void exampleMethod(String msg) {
            try {
                Thread.sleep(100); // Simulate some delay
                System.out.println(msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public int addNumbers(int a, int b) {
            return a + b;
        }
    }

    // Main method to test the functionality
    public static void main(String[] args) throws Exception {
        // Measure execution time of methods dynamically
        measureExecutionTime(ExampleClass.class, "exampleMethod", "Hello, Reflection!");
        measureExecutionTime(ExampleClass.class, "addNumbers",5,7);
    }
}
