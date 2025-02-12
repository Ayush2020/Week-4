package org.Capgemini.javaGenerics.Problem3UniversityCourseManagement;

import java.util.ArrayList;
import java.util.List;

// Abstract class representing different course evaluation types
abstract class CourseType {

    protected String evaluationType; // Evaluation type (Exam, Assignment, Research)

    // Constructor to initialize the evaluation type
    public CourseType(String evaluationType) {
        this.evaluationType = evaluationType;
    }

    // Abstract method that must be implemented by subclasses to return evaluation details
    public abstract String getEvaluationDetails();
}

// ExamCourse class extends CourseType and represents a course evaluated by exams
class ExamCourse extends CourseType {
    // Constructor to initialize the evaluation type as "Exam Based"
    public ExamCourse() {
        super("Exam Based!!");
    }

    // Implementing the abstract method to return the evaluation details specific to ExamCourse
    @Override
    public String getEvaluationDetails() {
        return "Evaluation Based on Exam!!";
    }
}

// AssingCourse class extends CourseType and represents a course evaluated by assignments
class AssingCourse extends CourseType {
    // Constructor to initialize the evaluation type as "Assignment Based"
    public AssingCourse() {
        super("Assing Based!!");
    }

    // Implementing the abstract method to return the evaluation details specific to AssingCourse
    @Override
    public String getEvaluationDetails() {
        return "Evaluation Based on Assingments!!";
    }
}

// ResearchCourse class extends CourseType and represents a course evaluated by research
class ResearchCourse extends CourseType {
    // Constructor to initialize the evaluation type as "Research Based"
    public ResearchCourse() {
        super("Reasearch Based!!");
    }

    // Implementing the abstract method to return the evaluation details specific to ResearchCourse
    @Override
    public String getEvaluationDetails() {
        return "Evaluation Based on Research!!";
    }
}

// Generic Course class to handle courses with different evaluation types
class Course<T extends CourseType> {
    private String courseName; // Course name (e.g., Mathematics, Major Project, etc.)
    private T course; // Course type (Exam, Assignment, Research)

    // Constructor to initialize course name and course type
    public Course(String courseName, T course) {
        this.courseName = courseName;
        this.course = course;
    }

    // Method to return the details of the course (name and evaluation type)
    public String getCourseDetails() {
        return "Course Name: " + courseName + ", Course: " + course.getEvaluationDetails();
    }

    // Static method that prints the evaluation details of all courses (using wildcards)
    public static void printAllCourses(List<? extends CourseType> courses) {
        for (CourseType courseType : courses) {
            System.out.println(courseType.getEvaluationDetails()); // Print the evaluation details of each course
        }
    }
}

public class UniversityCourseManagement {
    public static void main(String[] args) {
        // Create instances of different course types with their names
        Course<ExamCourse> exam = new Course<>("Mathematics", new ExamCourse());
        Course<AssingCourse> assign = new Course<>("Major Project", new AssingCourse());
        Course<ResearchCourse> research = new Course<>("Physical Ability", new ResearchCourse());

        // Print details of each course
        System.out.println(exam.getCourseDetails());
        System.out.println(assign.getCourseDetails());
        System.out.println(research.getCourseDetails());

        // Create a list of different course types and add course objects to it
        List<CourseType> courseList = new ArrayList<>();

        courseList.add(new ExamCourse()); // Adding an ExamCourse to the list
        courseList.add(new AssingCourse()); // Adding an AssingCourse to the list
        courseList.add(new ResearchCourse()); // Adding a ResearchCourse to the list

        System.out.println();

        // Call the static method to print evaluation details of all courses in the list
        Course.printAllCourses(courseList);
    }
}