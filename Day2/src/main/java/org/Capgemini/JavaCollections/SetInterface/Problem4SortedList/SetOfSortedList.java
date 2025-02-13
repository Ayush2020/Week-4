package org.Capgemini.JavaCollections.SetInterface.Problem4SortedList;


import java.util.Set;
import java.util.TreeSet;

public class SetOfSortedList {
    public static void main(String[] args) {
        //Tree Set
        Set<Integer> set = new TreeSet<Integer>();
        //Add elements to the set
        set.add(2);
        set.add(1);
        set.add(4);
        set.add(5);
        set.add(3);
        System.out.println("Sorted List : " + set);
    }
}
