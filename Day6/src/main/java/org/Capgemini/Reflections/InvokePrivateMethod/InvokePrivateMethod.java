package org.Capgemini.Reflections.InvokePrivateMethod;

import java.lang.reflect.Method;

class Calculator {
    // Private method
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class InvokePrivateMethod {
    public static void main(String[] args) {
        try {
            // Step 1: Create a Calculator object
            Calculator calculator = new Calculator();

            // Step 2: Get the Class object associated with the Calculator class
            Class<?> calculatorClass = calculator.getClass();

            // Step 3: Get the private method 'multiply' using reflection
            Method multiplyMethod = calculatorClass.getDeclaredMethod("multiply", int.class, int.class);

            // Step 4: Make the private method accessible
            multiplyMethod.setAccessible(true);

            // Step 5: Invoke the private method and pass arguments
            Object result = multiplyMethod.invoke(calculator, 5, 4);

            // Step 6: Display the result
            System.out.println("Result of multiplication: " + result);

        } catch (NoSuchMethodException | IllegalAccessException | java.lang.reflect.InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
