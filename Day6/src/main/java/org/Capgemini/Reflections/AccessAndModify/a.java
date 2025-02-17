package org.Capgemini.Reflections.AccessAndModify;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.AnnotatedElement;

// Step 1: Define the custom annotation @Author
@Retention(RetentionPolicy.RUNTIME)  // This ensures the annotation is available at runtime
@interface Author {
    String name();
}

// Step 2: Apply the annotation to a class
@Author(name = "John Doe")
class Book {

    public void displayBook() {
        System.out.println("Displaying book details...");
    }

    public static void main(String[] args) {
        // Step 3: Retrieve the annotation at runtime using Reflection
        Class<Book> bookClass = Book.class;

        // Check if the class has the @Author annotation
        if (bookClass.isAnnotationPresent(Author.class)) {
            // Retrieve the @Author annotation
            Author authorAnnotation = bookClass.getAnnotation(Author.class);
            // Print the author's name
            System.out.println("Author: " + authorAnnotation.name());
        } else {
            System.out.println("No @Author annotation present.");
        }
    }
}

