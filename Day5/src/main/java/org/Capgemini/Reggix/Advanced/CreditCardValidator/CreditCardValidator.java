package org.Capgemini.Reggix.Advanced.CreditCardValidator;

public class CreditCardValidator {

    public static boolean isValidCreditCard(String cardNumber) {
        // Check if the card number is exactly 16 digits
        if (cardNumber.length() != 16) {
            return false;
        }

        // Check if the card number contains only digits
        if (!cardNumber.matches("\\d+")) {
            return false;
        }

        // Validate Visa (starts with 4) or MasterCard (starts with 5)
        if ((cardNumber.startsWith("4") && cardNumber.length() == 16) ||
                (cardNumber.startsWith("5") && cardNumber.length() == 16)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String cardNumber = "4111111111111111"; // Example Visa card number

        if (isValidCreditCard(cardNumber)) {
            System.out.println(cardNumber + " is a valid credit card number.");
        } else {
            System.out.println(cardNumber + " is not a valid credit card number.");
        }
    }
}

