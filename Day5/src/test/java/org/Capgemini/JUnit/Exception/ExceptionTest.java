package org.Capgemini.JUnit.Exception;

import static org.junit.jupiter.api.Assertions.*;
import org.Capgemini.JUnit.Exception.ExceptionTest;

import org.junit.jupiter.api.Test;

public class ExceptionTest {

    // Create a Calculator instance
    private Exception calculator = new Exception();

    // Test to verify that an exception is thrown when dividing by zero
    @Test
    public void testDivideByZero() {
        // Using assertThrows to verify that ArithmeticException is thrown
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(10, 0); // This should throw ArithmeticException
        });

        // Verify that the exception message is as expected
        assertEquals("Division by zero is not allowed", exception.getMessage(),
                "Exception message should be 'Division by zero is not allowed'");
    }

    // Test for valid division (for completeness)
    @Test
    public void testDivideValid() {
        assertEquals(2, calculator.divide(10, 5), "10 divided by 5 should be 2");
    }
}
