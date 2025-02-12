package org.Capgemini.javaGenerics.Problem5ResumeScreeningSystem;

import java.util.ArrayList;
import java.util.List;

// Abstract class representing a generic Job Role
abstract class JobRole {
    private String roleName;

    public JobRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    // Abstract method to evaluate resume for the specific job role
    public abstract void evaluateResume();
}

// Concrete class for Software Engineer role
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer");
    }

    @Override
    public void evaluateResume() {
        System.out.println("Evaluating resume for Software Engineer: Checking programming skills, algorithms, and system design.");
    }
}

// Concrete class for Data Scientist role
class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist");
    }

    @Override
    public void evaluateResume() {
        System.out.println("Evaluating resume for Data Scientist: Checking data analysis, machine learning, and statistical skills.");
    }
}

// Concrete class for Product Manager role
class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager");
    }

    @Override
    public void evaluateResume() {
        System.out.println("Evaluating resume for Product Manager: Checking product lifecycle management, communication, and leadership skills.");
    }
}

// Generic class to represent a Resume for a specific Job Role
class Resume<T extends JobRole> {
    private String applicantName;
    private T jobRole;

    public Resume(String applicantName, T jobRole) {
        this.applicantName = applicantName;
        this.jobRole = jobRole;
    }

    public void processResume() {
        System.out.println("Processing resume for " + applicantName + " applying for " + jobRole.getRoleName() + ":");
        jobRole.evaluateResume();
    }
}

// AI-Driven Resume Screening System
public class ResumeScreeningSystem {
    // Wildcard method to process a list of resumes for multiple job roles
    public static void screenResumes(List<? extends JobRole> resumes) {
        for (JobRole resume : resumes) {
            resume.evaluateResume();
        }
    }

    public static void main(String[] args) {
        // Create resumes for different job roles
        Resume<SoftwareEngineer> resume1 = new Resume<>("Gautam", new SoftwareEngineer());
        Resume<DataScientist> resume2 = new Resume<>("Shriyansh", new DataScientist());
        Resume<ProductManager> resume3 = new Resume<>("Himasnshu", new ProductManager());

        // Process individual resumes
        System.out.println("Processing Individual Resumes:");
        resume1.processResume();
        resume2.processResume();
        resume3.processResume();

        // Create a list of resumes for screening
        List<JobRole> resumes = new ArrayList<>();
        resumes.add(new SoftwareEngineer());
        resumes.add(new DataScientist());
        resumes.add(new ProductManager());

        // Screen resumes using the wildcard method
        System.out.println("\nScreening Resumes in Bulk:");
        screenResumes(resumes);
    }
}