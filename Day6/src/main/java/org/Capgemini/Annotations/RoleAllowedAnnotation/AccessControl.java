package org.Capgemini.Annotations.RoleAllowedAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

// Define the @RoleAllowed annotation
@Target(ElementType.METHOD) // Can be applied to methods
@Retention(RetentionPolicy.RUNTIME) // Retained at runtime for reflection
@interface RoleAllowed {
    String value(); // Role allowed to access the method (e.g., "ADMIN")
}


// Class that simulates Role-Based Access Control
public class AccessControl {

    private String currentUserRole; // Simulate the current user's role

    // Constructor to set the current user role
    public AccessControl(String currentUserRole) {
        this.currentUserRole = currentUserRole;
    }

    // Method to validate access based on role
    public void validateAccess(Method method) {
        // Check if method has the @RoleAllowed annotation
        if (method.isAnnotationPresent(RoleAllowed.class)) {
            RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
            String allowedRole = roleAllowed.value();

            // Check if current user has the required role
            if (!currentUserRole.equals(allowedRole)) {
                System.out.println("Access Denied! You do not have the required role: " + allowedRole);
                return;
            }
        }

        // If role matches or no annotation is present, invoke the method
        try {
            method.invoke(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method with role-based access control for "ADMIN"
    @RoleAllowed("ADMIN")
    public void adminMethod() {
        System.out.println("Access granted to admin method.");
    }

    // Method without any role restriction
    public void publicMethod() {
        System.out.println("Access granted to public method.");
    }

    public static void main(String[] args) throws Exception {
        // Simulate user roles (for testing)
        AccessControl adminAccess = new AccessControl("ADMIN");
        AccessControl userAccess = new AccessControl("USER");

        // Get the methods of the AccessControl class
        Method adminMethod = AccessControl.class.getDeclaredMethod("adminMethod");
        Method publicMethod = AccessControl.class.getDeclaredMethod("publicMethod");

        // Test with admin role
        System.out.println("Testing with ADMIN role:");
        adminAccess.validateAccess(adminMethod); // Should be allowed
        adminAccess.validateAccess(publicMethod); // Should be allowed

        // Test with user role
        System.out.println("\nTesting with USER role:");
        userAccess.validateAccess(adminMethod); // Should be denied
        userAccess.validateAccess(publicMethod); // Should be allowed
    }
}
