package org.Capgemini.JavaCollections.MapInterface.Problem3HighestValue;
import java.util.*;

public class HighestValue {
    public static void main(String[] args) {
        // Example input map
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);

        // Call the method to find the key with the highest value
        String keyWithMaxValue = findKeyWithMaxValue(map);

        // Print the result
        System.out.println("Key with the highest value: " + keyWithMaxValue);
    }

    // Method to find the key with the highest value
    public static String findKeyWithMaxValue(Map<String, Integer> map) {
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        // Iterate through the map
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            // If the current value is greater than the maxValue
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey(); // Update the key with the highest value
            }
        }

        return maxKey;
    }
}
