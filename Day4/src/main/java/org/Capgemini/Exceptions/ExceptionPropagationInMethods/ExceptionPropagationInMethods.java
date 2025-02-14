package org.Capgemini.Exceptions.ExceptionPropagationInMethods;

public class ExceptionPropagationInMethods {

    // method1 throws ArithmeticException
    public static void method1() {
        // This will cause an ArithmeticException (division by zero)
        int result = 10 / 0;
    }

    // method2 calls method1, which propagates the exception
    public static void method2() {
        method1();  // Propagates ArithmeticException from method1
    }

    public static void main(String[] args) {
        try {
            // main calls method2, which propagates the exception from method1
            method2();
        } catch (ArithmeticException e) {
            // Handle the exception in the main method
            System.out.println("Handled exception in main");
        }
    }
}
