package org.Capgemini.JavaCollections.MapInterface.Problem4MergeTwoMaps;



import java.util.*;

public class MergeTwoMaps {

    // Method to merge two maps where if a key exists in both maps, their values are summed
    public static Map<String, Integer> mergeTwoMaps(Map<String, Integer> m1, Map<String, Integer> m2) {
        // Iterate over each entry in the second map (m2)
        for (Map.Entry<String, Integer> entry : m2.entrySet()) {
            // Check if the key from m2 already exists in m1
            if (m1.containsKey(entry.getKey())) {
                // If key exists in m1, sum the values (current value in m1 + value in m2)
                m1.put(entry.getKey(), m1.get(entry.getKey()) + entry.getValue());
            } else {
                // If key does not exist in m1, simply add the key-value pair from m2
                m1.put(entry.getKey(), entry.getValue());
            }
        }
        // Return the modified m1 map with merged values
        return m1;
    }

    public static void main(String[] args) {
        // Create and initialize the first map (m1)
        Map<String, Integer> m1 = new HashMap<>();
        m1.put("A", 1);
        m1.put("B", 2);

        // Create and initialize the second map (m2)
        Map<String, Integer> m2 = new HashMap<>();
        m2.put("B", 3);
        m2.put("C", 4);

        // Call the merge method and store the result in m3
        Map<String, Integer> m3 = mergeTwoMaps(m1, m2);

        // Print the merged map
        System.out.println(m3);
    }
}

