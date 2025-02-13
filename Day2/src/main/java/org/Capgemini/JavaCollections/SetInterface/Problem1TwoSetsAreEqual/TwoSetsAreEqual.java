package org.Capgemini.JavaCollections.SetInterface.Problem1TwoSetsAreEqual;


import java.util.HashSet;
import java.util.Set;

public class TwoSetsAreEqual {
    public static void main(String[] args) {
        //Create TwoSets
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        //Add Elemets to Set1
        set1.add(1);
        set1.add(2);
        set1.add(3);

        //Add Elemstes to set2
        set2.add(3);
        set2.add(2);
        set2.add(1);

        //Check if they are equal or not if equals return True
        boolean equals = set1.equals(set2);
        //Output
        System.out.println("Are they Equal: " + equals);
    }
}
