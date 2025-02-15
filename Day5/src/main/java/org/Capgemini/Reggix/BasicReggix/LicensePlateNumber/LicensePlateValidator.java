package org.Capgemini.Reggix.BasicReggix.LicensePlateNumber;

public class LicensePlateValidator {

    public static String validateLicensePlate(String licensePlate) {
        // Regular expression to match the required format: two uppercase letters followed by four digits
        if (licensePlate.matches("^[A-Z]{2}\\d{4}$")) {
            return "Valid";
        } else {
            return "Invalid";
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(validateLicensePlate("AB1234"));  // Valid
        System.out.println(validateLicensePlate("A12345"));  // Invalid (only one letter at the start)
        System.out.println(validateLicensePlate("AB12"));    // Invalid (not enough digits)
        System.out.println(validateLicensePlate("ab1234"));  // Invalid (lowercase letters)
    }
}
