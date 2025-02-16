package org.Capgemini.JUnit.Calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.Capgemini.JUnit.Calculator.Calculator;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    // Test for addition
    @Test
    void testAddition() {
        Calculator calc = new Calculator();
        assertEquals(10, calc.add(5, 5), "Addition should be correct");
    }

    // Test for subtraction
    @Test
    void testSubtraction() {
        Calculator calc = new Calculator();
        assertEquals(3, calc.subtract(5, 2), "Subtraction should be correct");
    }

    // Test for multiplication
    @Test
    void testMultiplication() {
        Calculator calc = new Calculator();
        assertEquals(20, calc.multiply(4, 5), "Multiplication should be correct");
    }

    // Test for division
    @Test
    void testDivision() {
        Calculator calc = new Calculator();
        assertEquals(2.0, calc.divide(10, 5), "Division should be correct");
    }

    // Test for division by zero (exception case)
    @Test
    void testDivisionByZero() {
        Calculator calc = new Calculator();
        // Assert that an ArithmeticException is thrown
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            calc.divide(10, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }


}
