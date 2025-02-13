package org.Capgemini.JavaCollections.SetInterface.Problem2SetOperations;
import java.util.HashSet;
import java.util.Set;

public class SetOperations {
    public static void main(String[] args) {
        //Creaate teo sets
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        //Add Elements to Set1
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);

        //Add Elements to Set2
        set2.add(6);
        set2.add(7);
        set2.add(3);
        set2.add(4);

        //Create a copy of set1 for a union
        Set<Integer> union = new HashSet<>(set1);
        //Add elemnts of Set2 to the union set
        union.addAll(set2);
        //Create a copy of set1 for intersection
        Set<Integer> intersection = new HashSet<>(set1);
        //Retain only the elements that are also in set2
        intersection.retainAll(set2);

        System.out.println("Set 1 : " + set1);
        System.out.println("Set 2 : " + set2);
        System.out.println("Union : " + union);
        System.out.println("Intersection : " + intersection);

    }
}
