package org.Capgemini.JavaStreams.Serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Step 1: Create the Employee class with Serializable interface
class Employee implements Serializable {
    private static final long serialVersionUID = 1L; // Ensures compatibility during deserialization

    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getter methods for displaying employee data
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', department='" + department + "', salary=" + salary + "}";
    }
}

public class Serialization {

    // Step 2: Serialize the list of employees to a file
    public static void serializeEmployees(List<Employee> employees, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized successfully.");
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }
    }

    // Step 3: Deserialize the list of employees from a file
    public static List<Employee> deserializeEmployees(String fileName) {
        List<Employee> employees = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            employees = (List<Employee>) ois.readObject();
            System.out.println("Employees deserialized successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
        }
        return employees;
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Creating a list of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John Doe", "IT", 60000));
        employees.add(new Employee(2, "Jane Smith", "HR", 50000));
        employees.add(new Employee(3, "Bob Johnson", "Finance", 70000));

        String fileName = "D:/IntelliC/Week4/Day3/src/main/java/org/Capgemini/JavaStreams/Serialization/employee.ser"; // File to save the serialized data

        // Step 4: Serialize employees to the file
        serializeEmployees(employees, fileName);

        // Step 5: Deserialize employees from the file and display
        List<Employee> deserializedEmployees = deserializeEmployees(fileName);
        if (deserializedEmployees != null) {
            for (Employee employee : deserializedEmployees) {
                System.out.println(employee);
            }
        }
    }
}

