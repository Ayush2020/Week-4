package org.Capgemini.JavaCollections.SetInterface.Problem5Subsets;


import java.util.HashSet;
import java.util.Set;

public class SubSets {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        // Adding elements to Set1
        set1.add(2);
        set1.add(3);
        // Adding elements to Set2
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        // Check if Set1 is a subset of Set2
        boolean result = set2.containsAll(set1);
        System.out.println(result);
    }
}
