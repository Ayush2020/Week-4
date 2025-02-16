package org.Capgemini.JUnit.TemperatureConverter;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TemperatureConverterTest {

    private TemperatureConverter converter = new TemperatureConverter();

    // Test converting Celsius to Fahrenheit
    @Test
    public void testCelsiusToFahrenheit() {
        // Test with standard Celsius values
        assertEquals(32.0, converter.celsiusToFahrenheit(0.0), "0°C should be 32°F.");

    }

    // Test converting Fahrenheit to Celsius
    @Test
    public void testFahrenheitToCelsius() {
        // Test with standard Fahrenheit values
        assertEquals(0.0, converter.fahrenheitToCelsius(32.0), "32°F should be 0°C.");

    }

    // Test for non-standard values
    @Test
    public void testNonStandardValues() {
        assertEquals(98.6, converter.celsiusToFahrenheit(37.0), "37°C should be 98.6°F.");

    }
}
