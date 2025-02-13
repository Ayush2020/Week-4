package org.Capgemini.JavaCollections.SetInterface.ProblemInsuranceManagementSystem;

import java.time.LocalDate;

public class Policy {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    // Constructor
    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    // Getters and toString
    public String getPolicyNumber() {
        return policyNumber;
    }


    public String getCoverageType() {
        return coverageType;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return "PolicyNumber: " + policyNumber + ", Policyholder: " + policyholderName + ", Expiry: " + expiryDate +
                ", Coverage: " + coverageType + ", Premium: $" + premiumAmount;
    }

    // Overriding equals() and hashCode() to ensure uniqueness based on Policy Number
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Policy policy = (Policy) obj;
        return policyNumber.equals(policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return policyNumber.hashCode();
    }
}
