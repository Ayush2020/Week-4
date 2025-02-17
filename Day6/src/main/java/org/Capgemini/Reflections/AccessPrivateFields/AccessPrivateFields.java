package org.Capgemini.Reflections.AccessPrivateFields;

import java.lang.reflect.Field;

class Person {
    // Private field
    private int age;

    // Constructor
    public Person(int age) {
        this.age = age;
    }
}

public class AccessPrivateFields {
    public static void main(String[] args) {
        try {
            // Step 1: Create a Person object
            Person person = new Person(25);

            // Step 2: Get the Class object associated with the Person class
            Class<?> personClass = person.getClass();

            // Step 3: Get the private field 'age' using reflection
            Field ageField = personClass.getDeclaredField("age");

            // Step 4: Make the private field accessible
            ageField.setAccessible(true);

            // Step 5: Get the value of the private field 'age'
            System.out.println("Original age: " + ageField.get(person));

            // Step 6: Modify the value of the private field 'age'
            ageField.set(person, 30); // Setting new age to 30

            // Step 7: Get the modified value of the private field 'age'
            System.out.println("Modified age: " + ageField.get(person));

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
