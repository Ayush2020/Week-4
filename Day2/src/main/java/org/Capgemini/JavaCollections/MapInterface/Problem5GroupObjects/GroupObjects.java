package org.Capgemini.JavaCollections.MapInterface.Problem5GroupObjects;

import java.util.*;

class Employee {
    String name;
    Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name;
    }
}

enum Department {
    HR, IT ;
}

public class GroupObjects {

    public static Map<Department, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<Department, List<Employee>> departmentMap = new HashMap<>();

        // Iterate over the list of employees
        for (Employee employee : employees) {
            // If the department doesn't exist in the map, create a new list
            departmentMap.putIfAbsent(employee.getDepartment(), new ArrayList<>());

            // Add the employee to the appropriate department list
            departmentMap.get(employee.getDepartment()).add(employee);
        }

        return departmentMap;
    }

    public static void main(String[] args) {
        // Create a list of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", Department.HR));
        employees.add(new Employee("Bob", Department.IT));
        employees.add(new Employee("Carol", Department.HR));


        // Group employees by department
        Map<Department, List<Employee>> groupedEmployees = groupByDepartment(employees);

        // Print the grouped employees
        for (Map.Entry<Department, List<Employee>> entry : groupedEmployees.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

