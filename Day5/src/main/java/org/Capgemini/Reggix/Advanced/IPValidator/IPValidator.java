package org.Capgemini.Reggix.Advanced.IPValidator;

public class IPValidator {
    public static boolean isValidIP(String ip) {
        // Regular expression to match a valid IPv4 address
        String regex = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\."
                + "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\."
                + "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\."
                + "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

        // Check if the IP matches the regex
        return ip.matches(regex);
    }

    public static void main(String[] args) {
        String ip = "192.168.1.1"; // Example IP address

        if (isValidIP(ip)) {
            System.out.println(ip + " is a valid IPv4 address.");
        } else {
            System.out.println(ip + " is not a valid IPv4 address.");
        }
    }
}
