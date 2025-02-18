package org.Capgemini.Annotations.AnnotationReflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class AnnotationReflection {

    // Define the @ImportantMethod annotation
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ImportantMethod {
        String level() default "HIGH"; // Optional parameter with default value "HIGH"
    }

    // Class with methods annotated with @ImportantMethod
    public static class ExampleClass {

        @ImportantMethod(level = "HIGH")
        public void criticalMethod() {
            System.out.println("This is a critical method.");
        }

        @ImportantMethod(level = "MEDIUM")
        public void importantMethod() {
            System.out.println("This is an important method.");
        }

        public void regularMethod() {
            System.out.println("This is a regular method.");
        }
    }


    // Main method to reflect and print annotated methods
    public static void main(String[] args) throws Exception {
        Class<?> clazz = ExampleClass.class;

        // Get all methods of the ExampleClass
        Method[] methods = clazz.getDeclaredMethods();

        // Loop through the methods and check for the ImportantMethod annotation
        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + ", Importance Level: " + annotation.level());
            }
        }
    }
}

