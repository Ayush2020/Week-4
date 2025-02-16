package org.Capgemini.JUnit.ListManager;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class ListManagerTest {

    private ListManager listManager;
    private List<Integer> list;

    // Setting up the test environment
    @BeforeEach
    public void setUp() {
        listManager = new ListManager();
        list = new ArrayList<>();
    }

    // Test: Adding elements to the list
    @Test
    public void testAddElement() {
        listManager.addElement(list, 5);
        assertEquals(1, list.size(), "List size should be 1 after adding one element");
        assertTrue(list.contains(5), "List should contain the element 5");
    }

    // Test: Removing an element from the list
    @Test
    public void testRemoveElement() {
        listManager.addElement(list, 10);
        listManager.addElement(list, 20);
        boolean removed = listManager.removeElement(list, 10);
        assertTrue(removed, "Element 10 should be removed successfully");
        assertFalse(list.contains(10), "List should not contain the element 10 anymore");
        assertEquals(1, list.size(), "List size should be 1 after removal");
    }

    // Test: Checking the size of the list
    @Test
    public void testGetSize() {
        assertEquals(0, listManager.getSize(list), "List size should be 0 initially");
        listManager.addElement(list, 5);
        assertEquals(1, listManager.getSize(list), "List size should be 1 after adding one element");
    }
}
