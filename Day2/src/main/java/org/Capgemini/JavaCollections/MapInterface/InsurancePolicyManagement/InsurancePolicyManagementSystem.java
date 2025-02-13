package org.Capgemini.JavaCollections.MapInterface.InsurancePolicyManagement;

import java.time.LocalDate;
import java.util.*;

class Policy {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    // Constructor to initialize the policy object
    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public String toString() {
        return "PolicyNumber: " + policyNumber + ", Policyholder: " + policyholderName + ", Expiry Date: " + expiryDate + ", Coverage: " + coverageType + ", Premium: " + premiumAmount;
    }
}

public class InsurancePolicyManagementSystem {

    // HashMap to store policies with policy number as the key
    private Map<String, Policy> policyHashMap = new HashMap<>();
    // LinkedHashMap to store policies while maintaining insertion order
    private Map<String, Policy> policyLinkedHashMap = new LinkedHashMap<>();
    // TreeMap to store policies sorted by expiry date
    private Map<String, Policy> policyTreeMap = new TreeMap<>(Comparator.comparing(policyNumber -> policyHashMap.get(policyNumber).getExpiryDate()));

    // Method to add a policy to all three maps
    public void addPolicy(Policy policy) {
        policyHashMap.put(policy.getPolicyNumber(), policy);
        policyLinkedHashMap.put(policy.getPolicyNumber(), policy);
        policyTreeMap.put(policy.getPolicyNumber(), policy);
    }

    // Retrieve a policy by its number
    public Policy getPolicyByNumber(String policyNumber) {
        return policyHashMap.get(policyNumber); // HashMap for quick lookup
    }

    // List policies expiring within the next 30 days
    public List<Policy> getPoliciesExpiringSoon() {
        List<Policy> expiringPolicies = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate in30Days = today.plusDays(30);
        for (Policy policy : policyHashMap.values()) {
            if (policy.getExpiryDate().isBefore(in30Days) && policy.getExpiryDate().isAfter(today)) {
                expiringPolicies.add(policy);
            }
        }
        return expiringPolicies;
    }

    // List policies for a specific policyholder
    public List<Policy> getPoliciesByPolicyholder(String policyholderName) {
        List<Policy> policies = new ArrayList<>();
        for (Policy policy : policyHashMap.values()) {
            if (policy.getPolicyholderName().equalsIgnoreCase(policyholderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    // Remove expired policies from all maps
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        policyHashMap.values().removeIf(policy -> policy.getExpiryDate().isBefore(today));
        policyLinkedHashMap.values().removeIf(policy -> policy.getExpiryDate().isBefore(today));
        policyTreeMap.values().removeIf(policy -> policy.getExpiryDate().isBefore(today));
    }

    // Method to display all policies in any of the maps
    public void displayPolicies(Map<String, Policy> policyMap) {
        for (Policy policy : policyMap.values()) {
            System.out.println(policy);
        }
    }

    public static void main(String[] args) {
        InsurancePolicyManagementSystem system = new InsurancePolicyManagementSystem();

        // Adding some policies
        system.addPolicy(new Policy("P001", "Alice", LocalDate.of(2025, 5, 20), "Health", 2000));
        system.addPolicy(new Policy("P002", "Bob", LocalDate.of(2023, 2, 15), "Auto", 1500));
        system.addPolicy(new Policy("P003", "Carol", LocalDate.of(2024, 12, 10), "Home", 2500));
        system.addPolicy(new Policy("P004", "Alice", LocalDate.of(2024, 10, 25), "Health", 1800));

        // Displaying all policies
        System.out.println("All Policies:");
        system.displayPolicies(system.policyHashMap);

        // Retrieving a policy by number
        System.out.println("\nPolicy with Number P001:");
        System.out.println(system.getPolicyByNumber("P001"));

        // List policies expiring within the next 30 days
        System.out.println("\nPolicies Expiring Soon:");
        List<Policy> expiringPolicies = system.getPoliciesExpiringSoon();
        for (Policy policy : expiringPolicies) {
            System.out.println(policy);
        }

        // List policies for a specific policyholder (Alice)
        System.out.println("\nPolicies for Alice:");
        List<Policy> alicePolicies = system.getPoliciesByPolicyholder("Alice");
        for (Policy policy : alicePolicies) {
            System.out.println(policy);
        }

        // Remove expired policies
        system.removeExpiredPolicies();
        System.out.println("\nPolicies after removing expired ones:");
        system.displayPolicies(system.policyHashMap);
    }
}
