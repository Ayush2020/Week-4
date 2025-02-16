package org.Capgemini.JUnit.NumberUtils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberUtilsTest {

    // Create an instance of the NumberUtils class
    private NumberUtils numberUtils = new NumberUtils();

    // Parameterized test using @ValueSource
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6}) // Test with even numbers
    public void testIsEvenForEvenNumbers(int number) {
        assertTrue(numberUtils.isEven(number), number + " should be even.");
    }

    // Parameterized test using @ValueSource
    @ParameterizedTest
    @ValueSource(ints = {7, 9}) // Test with odd numbers
    public void testIsEvenForOddNumbers(int number) {
        assertFalse(numberUtils.isEven(number), number + " should be odd.");
    }
}
