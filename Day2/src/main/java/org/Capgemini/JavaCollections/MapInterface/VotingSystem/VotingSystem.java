package org.Capgemini.JavaCollections.MapInterface.VotingSystem;

import java.util.*;

public class VotingSystem {

    // HashMap to store candidate names and their votes
    private Map<String, Integer> votesMap = new HashMap<>();
    // TreeMap to display results in sorted order (by candidate name)
    private Map<String, Integer> sortedVotesMap = new TreeMap<>();
    // LinkedHashMap to maintain the order of votes (preserving the insertion order)
    private Map<String, Integer> orderedVotesMap = new LinkedHashMap<>();

    // Method to cast a vote for a candidate
    public void castVote(String candidate) {
        // Update HashMap vote count
        votesMap.put(candidate, votesMap.getOrDefault(candidate, 0) + 1);

        // Update LinkedHashMap vote count (preserving insertion order)
        orderedVotesMap.put(candidate, orderedVotesMap.getOrDefault(candidate, 0) + 1);
    }

    // Method to display votes using HashMap (no specific order)
    public void displayVotesHashMap() {
        System.out.println("Votes (HashMap - No Specific Order):");
        for (Map.Entry<String, Integer> entry : votesMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }
    }

    // Method to display votes using TreeMap (sorted alphabetically)
    public void displayVotesTreeMap() {
        sortedVotesMap.putAll(votesMap);  // Copy votes from HashMap to TreeMap for sorted display
        System.out.println("\nVotes (TreeMap - Sorted Alphabetically by Candidate Name):");
        for (Map.Entry<String, Integer> entry : sortedVotesMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }
    }

    // Method to display votes using LinkedHashMap (preserving insertion order)
    public void displayVotesLinkedHashMap() {
        System.out.println("\nVotes (LinkedHashMap - Insertion Order):");
        for (Map.Entry<String, Integer> entry : orderedVotesMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }
    }

    // Method to display the candidate with the most votes
    public void displayWinner() {
        String winner = Collections.max(votesMap.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("\nWinner: " + winner + " with " + votesMap.get(winner) + " votes.");
    }

    // Main method to test the voting system
    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();

        // Casting some votes
        system.castVote("Alice");
        system.castVote("Bob");
        system.castVote("Alice");
        system.castVote("Charlie");
        system.castVote("Bob");
        system.castVote("Alice");

        // Display results in different ways
        system.displayVotesHashMap();
        system.displayVotesTreeMap();
        system.displayVotesLinkedHashMap();
        system.displayWinner();
    }
}

