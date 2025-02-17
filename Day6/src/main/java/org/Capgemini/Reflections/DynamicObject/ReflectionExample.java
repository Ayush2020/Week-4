package org.Capgemini.Reflections.DynamicObject;

import java.lang.reflect.Constructor;

class Student {
    private String name;
    private int age;

    // Constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Method to display student information
    public void displayStudentInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Student Age: " + age);
    }
}

public class ReflectionExample {
    public static void main(String[] args) {
        try {
            // Load the Student class dynamically using reflection
            Class<?> studentClass = Class.forName("Student");

            // Get the constructor of Student class with parameters (String, int)
            Constructor<?> constructor = studentClass.getConstructor(String.class, int.class);

            // Create an instance of Student dynamically using the constructor
            Object studentObject = constructor.newInstance("John Doe", 20);

            // Cast the object to Student type and call the method
            Student student = (Student) studentObject;
            student.displayStudentInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
