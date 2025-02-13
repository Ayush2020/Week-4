package org.Capgemini.JavaCollections.SetInterface.Problem3SymmetricDiference;

import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {
    public static void main(String[] args) {
        // Create the first set and add elements to it
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);

        // Create the second set and add elements to it
        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(6);


        // Create a new set and initialize it with the elements of set1
        Set<Integer> symmetricDifference = new HashSet<>(set1);
        // Add all elements of set2 to the new set (this results in the union of set1 and set2)
        symmetricDifference.addAll(set2);


        // Create a new set and initialize it with the elements of set1
        Set<Integer> intersection = new HashSet<>(set1);
        // Retain only the elements that are also present in set2 (this results in the intersection)
        intersection.retainAll(set2);


        // Remove all elements of the intersection from the union set
        // This leaves only the elements that are in either set1 or set2 but not in both
        symmetricDifference.removeAll(intersection);

        // Print the symmetric difference
        System.out.println("Symmetric Difference: " + symmetricDifference);
    }
}
