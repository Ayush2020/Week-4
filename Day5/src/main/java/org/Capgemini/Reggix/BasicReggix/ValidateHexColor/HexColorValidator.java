package org.Capgemini.Reggix.BasicReggix.ValidateHexColor;

public class HexColorValidator {

    public static String validateHexColor(String colorCode) {
        // Regular expression to match the valid hex color format: # followed by exactly 6 hexadecimal characters
        if (colorCode.matches("^#[0-9A-Fa-f]{6}$")) {
            return "Valid";
        } else {
            return "Invalid";
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(validateHexColor("#FFA500"));  // Valid
        System.out.println(validateHexColor("#ff4500"));  // Valid
        System.out.println(validateHexColor("#123"));     // Invalid (too short)
        System.out.println(validateHexColor("#123XYZ"));  // Invalid (non-hex characters)
    }
}
