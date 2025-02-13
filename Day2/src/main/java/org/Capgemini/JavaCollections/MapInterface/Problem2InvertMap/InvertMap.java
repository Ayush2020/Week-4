package org.Capgemini.JavaCollections.MapInterface.Problem2InvertMap;

import java.util.*;

import java.util.*;

public class InvertMap {

    // Method to invert the map
    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> originalMap) {
        Map<V, List<K>> invertedMap = new HashMap<>();

        // Iterate through the original map
        for (Map.Entry<K, V> entry : originalMap.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();

            List<K> keys = invertedMap.containsKey(value) ? invertedMap.get(value) : new ArrayList<>();

            // Add the key to the list of keys for that value
            keys.add(key);

            // Put the updated list back into the inverted map
            invertedMap.put(value, keys);
        }

        return invertedMap;
    }

    public static void main(String[] args) {
        // Original map
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("A", 1);
        originalMap.put("B", 2);
        originalMap.put("C", 1);

        // Call the method to invert the map
        Map<Integer, List<String>> invertedMap = invertMap(originalMap);

        // Print the inverted map
        System.out.println("Inverted Map: " + invertedMap);
    }
}

