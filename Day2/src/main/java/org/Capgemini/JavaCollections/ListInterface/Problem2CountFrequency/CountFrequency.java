package org.Capgemini.JavaCollections.ListInterface.Problem2CountFrequency;
import java.util.*;

// Class definition
public class CountFrequency {

    // Method to count the frequency of each element in the list
    public static Map<String, Integer> countFrequency(List<String> list) {
        // Create a HashMap to store the frequency of each element
        Map<String, Integer> frequencyMap = new HashMap<>();

        // Iterate through each element in the list
        for (String element : list) {
            // Check if the element is already present in the map
            if (frequencyMap.containsKey(element)) {
                // If present, increment its count by 1
                frequencyMap.put(element, frequencyMap.get(element) + 1);
            } else {
                // If not present, add the element to the map with a count of 1
                frequencyMap.put(element, 1);
            }
        }

        // Return the frequency map containing the count of each element
        return frequencyMap;
    }

    // Main method
    public static void main(String[] args) {
        // Create a list of strings
        List<String> list = new ArrayList<>();

        // Add elements to the list
        list.add("apple");
        list.add("banana");
        list.add("apple");
        list.add("orange");

        // Call the countFrequency method to compute the frequency of each element
        Map<String, Integer> frequency = countFrequency(list);

        // Print the frequency map
        System.out.println("Frequency: " + frequency);
    }
}