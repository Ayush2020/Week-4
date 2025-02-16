package org.Capgemini.JUnit.StringUtility;
public class StringUtils {

    // Reverse a string
    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder reversedString = new StringBuilder(str);
        return reversedString.reverse().toString();
    }

    // Check if the string is a palindrome
    public static boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        String reversedStr = reverse(str);
        return str.equals(reversedStr);
    }

    // Convert a string to uppercase
    public static String toUpperCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase();
    }

}
