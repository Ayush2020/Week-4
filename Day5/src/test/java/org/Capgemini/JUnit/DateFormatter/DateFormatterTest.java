package org.Capgemini.JUnit.DateFormatter;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DateFormatterTest {

    private DateFormatter dateFormatter = new DateFormatter();

    // Test with valid date formats
    @Test
    public void testValidDateFormat() {
        // Test a valid date in yyyy-MM-dd format
        String inputDate = "2025-02-15";
        String expectedDate = "15-02-2025";
        assertEquals(expectedDate, dateFormatter.formatDate(inputDate), "The date should be correctly formatted to dd-MM-yyyy.");
    }

    // Test with an invalid date format (too short)
    @Test
    public void testInvalidDateFormat() {
        String invalidDate = "2025-02";
        assertNull(dateFormatter.formatDate(invalidDate), "The date should return null for an invalid date format.");
    }

}
