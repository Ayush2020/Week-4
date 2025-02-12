package org.Capgemini.JavaCollections.ListInterface.Problem4RemoveDuplicates;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        // Creating a LinkedHashSet to store elements
        // LinkedHashSet is used to preserve the insertion order and automatically removes duplicates
        Set set = new LinkedHashSet(Arrays.asList("3", "1", "2", "2", "3", "4" ));
        // Printing the set, duplicates will be removed and order will be preserved
        System.out.println(set);  // Output: [3, 2, 1, 4]
    }
}

