package org.Capgemini.JavaCollections.SetInterface.ProblemInsuranceManagementSystem;
import java.time.LocalDate;


public class InsuranceManagementSystem {
    public static void main(String[] args) {
        // Creating the InsurancePolicyManager
        InsurancePolicyManager manager = new InsurancePolicyManager();

        // Adding policies
        manager.addPolicy(new Policy("P123", "Gautam", LocalDate.of(2025, 5, 20), "Health", 500.0));
        manager.addPolicy(new Policy("P124", "Shriyansh", LocalDate.of(2025, 2, 28), "Auto", 150.0));
        manager.addPolicy(new Policy("P125", "Zekrom", LocalDate.of(2025, 3, 15), "Home", 200.0));

        // Displaying all policies
        manager.displayAllPolicies();

        // Displaying policies expiring soon
        manager.displayExpiringSoon();

        // Displaying policies with a specific coverage type
        manager.displayPoliciesByCoverageType("Health");

        // Checking for duplicate policies
        manager.checkForDuplicatePolicies();

        // Performance comparison
        manager.comparePerformance();
    }
}

