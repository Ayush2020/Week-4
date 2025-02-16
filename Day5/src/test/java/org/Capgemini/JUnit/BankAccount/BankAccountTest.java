package org.Capgemini.JUnit.BankAccount;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    private BankAccount bankAccount;

    // Set up a new bank account with an initial balance before each test
    @BeforeEach
    public void setUp() {
        bankAccount = new BankAccount(1000.0);  // Start with a balance of 1000
    }

    // Test that depositing money correctly updates the balance
    @Test
    public void testDeposit() {
        bankAccount.deposit(500.0);
        assertEquals(1500.0, bankAccount.getBalance(), "The balance should be 1500 after depositing 500.");
    }

    // Test that withdrawing money correctly updates the balance
    @Test
    public void testWithdraw() {
        boolean success = bankAccount.withdraw(400.0);
        assertTrue(success, "Withdrawal should be successful if there are sufficient funds.");
        assertEquals(600.0, bankAccount.getBalance(), "The balance should be 600 after withdrawing 400.");
    }

    // Test that withdrawing more money than available fails
    @Test
    public void testWithdrawInsufficientFunds() {
        boolean success = bankAccount.withdraw(1500.0);  // Try to withdraw more than the balance
        assertFalse(success, "Withdrawal should fail if there are insufficient funds.");
        assertEquals(1000.0, bankAccount.getBalance(), "The balance should remain 1000 after a failed withdrawal.");
    }

    // Test that balance is correct after multiple operations
    @Test
    public void testMultipleTransactions() {
        bankAccount.deposit(200.0);  // Balance should now be 1200
        bankAccount.withdraw(300.0); // Balance should now be 900
        bankAccount.deposit(500.0);  // Balance should now be 1400
        assertEquals(1400.0, bankAccount.getBalance(), "The final balance should be 1400 after the transactions.");
    }
}
