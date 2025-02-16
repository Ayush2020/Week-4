package org.Capgemini.JUnit.DataBaseConnection;

import static org.junit.jupiter.api.Assertions.*;

import org.Capgemini.JUnit.DataBaseConnection.DatabaseConnection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class DatabaseConnectionTest {

    private DatabaseConnection dbConnection;

    // Using @BeforeEach to initialize the database connection before each test
    @BeforeEach
    public void setUp() {
        dbConnection = new DatabaseConnection();
        dbConnection.connect(); // Simulate connecting to the database
    }

    // Using @AfterEach to close the connection after each test
    @AfterEach
    public void tearDown() {
        dbConnection.disconnect(); // Simulate disconnecting from the database
    }

    // Test to verify the connection is established correctly
    @Test
    public void testConnectionEstablished() {
        assertTrue(dbConnection.isConnected(), "Database should be connected");
    }

    // Test to verify the connection is closed correctly
    @Test
    public void testConnectionClosed() {
        // First connect
        dbConnection.connect();
        assertTrue(dbConnection.isConnected(), "Database should be connected");

        // Then disconnect
        dbConnection.disconnect();
        assertFalse(dbConnection.isConnected(), "Database should be disconnected");
    }
}
