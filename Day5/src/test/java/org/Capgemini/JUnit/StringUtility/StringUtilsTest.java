package org.Capgemini.JUnit.StringUtility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void reverse() {
        assertEquals("cba", StringUtils.reverse("abc"), "The reverse of 'abc' should be 'cba'");
        assertEquals("madam", StringUtils.reverse("madam"), "The reverse of 'madam' should be 'madam'");
    }

    @Test
    void isPalindrome() {
        assertTrue(StringUtils.isPalindrome("madam"), "'madam' should be a palindrome");
        assertTrue(StringUtils.isPalindrome("racecar"), "'racecar' should be a palindrome");
    }

    @Test
    void toUpperCase() {
        assertEquals("HELLO", StringUtils.toUpperCase("hello"), "'hello' should be converted to 'HELLO'");
        assertEquals("WORLD", StringUtils.toUpperCase("world"), "'world' should be converted to 'WORLD'");
    }
}