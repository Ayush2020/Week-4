package org.Capgemini.JUnit.DataBaseConnection;

public class DatabaseConnection {

    private boolean isConnected = false;

    // Method to simulate establishing a connection
    public void connect() {
        isConnected = true;
        System.out.println("Database connected.");
    }

    // Method to simulate closing the connection
    public void disconnect() {
        isConnected = false;
        System.out.println("Database disconnected.");
    }

    // Getter to check if the connection is established
    public boolean isConnected() {
        return isConnected;
    }
}
