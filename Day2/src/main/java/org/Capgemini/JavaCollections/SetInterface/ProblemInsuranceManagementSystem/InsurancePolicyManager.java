package org.Capgemini.JavaCollections.SetInterface.ProblemInsuranceManagementSystem;

import java.time.LocalDate;
import java.util.*;

public class InsurancePolicyManager {
    private Set<Policy> hashSet;
    private Set<Policy> linkedHashSet;
    private Set<Policy> treeSet;

    public InsurancePolicyManager() {
        this.hashSet = new HashSet<>();
        this.linkedHashSet = new LinkedHashSet<>();
        this.treeSet = new TreeSet<>(Comparator.comparing(Policy::getExpiryDate));
    }

    // Store policy in all sets
    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    // Retrieve all unique policies
    public void displayAllPolicies() {
        System.out.println("All Unique Policies:");
        hashSet.forEach(System.out::println);
    }

    // Policies expiring soon (within 30 days)
    public void displayExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate thirtyDaysLater = today.plusDays(30);

        System.out.println("\nPolicies Expiring Soon:");
        hashSet.stream()
                .filter(policy -> policy.getExpiryDate().isBefore(thirtyDaysLater) && policy.getExpiryDate().isAfter(today))
                .forEach(System.out::println);
    }

    // Policies with a specific coverage type
    public void displayPoliciesByCoverageType(String coverageType) {
        System.out.println("\nPolicies with Coverage Type: " + coverageType);
        hashSet.stream()
                .filter(policy -> policy.getCoverageType().equalsIgnoreCase(coverageType))
                .forEach(System.out::println);
    }

    // Duplicate policies based on policy numbers (Checking for duplicate Policy Numbers)
    public void checkForDuplicatePolicies() {
        Set<String> uniquePolicyNumbers = new HashSet<>();
        Set<Policy> duplicatePolicies = new HashSet<>();

        for (Policy policy : hashSet) {
            if (!uniquePolicyNumbers.add(policy.getPolicyNumber())) {
                duplicatePolicies.add(policy);
            }
        }

        System.out.println("\nDuplicate Policies (Based on Policy Numbers):");
        duplicatePolicies.forEach(System.out::println);
    }

    // Performance comparison methods
    public void comparePerformance() {
        List<Policy> policies = new ArrayList<>();
        // Adding policies to a list
        for (int i = 0; i < 100000; i++) {
            policies.add(new Policy("Policy" + i, "Policyholder" + i, LocalDate.now().plusDays(i), "Health", 100.0));
        }

        System.out.println("\nPerformance Comparison (Adding, Removing, Searching):");

        // HashSet Performance
        long startTime = System.nanoTime();
        Set<Policy> hashSetTest = new HashSet<>(policies);
        long endTime = System.nanoTime();
        System.out.println("HashSet Add: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        hashSetTest.remove(policies.get(50000)); // Removing a policy
        endTime = System.nanoTime();
        System.out.println("HashSet Remove: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        hashSetTest.contains(policies.get(99999)); // Searching for a policy
        endTime = System.nanoTime();
        System.out.println("HashSet Search: " + (endTime - startTime) + " ns");

        // LinkedHashSet Performance
        startTime = System.nanoTime();
        Set<Policy> linkedHashSetTest = new LinkedHashSet<>(policies);
        endTime = System.nanoTime();
        System.out.println("LinkedHashSet Add: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        linkedHashSetTest.remove(policies.get(50000));
        endTime = System.nanoTime();
        System.out.println("LinkedHashSet Remove: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        linkedHashSetTest.contains(policies.get(99999));
        endTime = System.nanoTime();
        System.out.println("LinkedHashSet Search: " + (endTime - startTime) + " ns");

        // TreeSet Performance
        startTime = System.nanoTime();
        Set<Policy> treeSetTest = new TreeSet<>(Comparator.comparing(Policy::getExpiryDate));
        treeSetTest.addAll(policies);
        endTime = System.nanoTime();
        System.out.println("TreeSet Add: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        treeSetTest.remove(policies.get(50000));
        endTime = System.nanoTime();
        System.out.println("TreeSet Remove: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        treeSetTest.contains(policies.get(99999));
        endTime = System.nanoTime();
        System.out.println("TreeSet Search: " + (endTime - startTime) + " ns");
    }
}
