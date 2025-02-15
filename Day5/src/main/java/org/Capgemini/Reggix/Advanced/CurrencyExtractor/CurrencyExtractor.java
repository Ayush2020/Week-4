package org.Capgemini.Reggix.Advanced.CurrencyExtractor;

import java.util.*;
import java.util.regex.*;

public class CurrencyExtractor {

    public static List<String> extractCurrencyValues(String text) {
        // Regular expression to match currency values (with optional "$" sign)
        String regex = "(\\$?\\d+(?:\\.\\d{2})?)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> currencyValues = new ArrayList<>();
        while (matcher.find()) {
            currencyValues.add(matcher.group());
        }

        return currencyValues;
    }

    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";

        List<String> currencyValues = extractCurrencyValues(text);

        System.out.println("Extracted Currency Values: " + String.join(", ", currencyValues));
    }
}
