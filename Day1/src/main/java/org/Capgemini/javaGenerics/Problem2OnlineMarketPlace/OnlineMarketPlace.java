package org.Capgemini.javaGenerics.Problem2OnlineMarketPlace;

// Books class that extends Product
class Books extends Product {
    private String category; // Category of the book

    // Constructor to initialize price and category
    public Books(double price, String category) {
        this.price = price;
        this.category = category;
    }

    // Getter for price
    public double getPrice() {
        return price;
    }

    // Getter for category
    public String getCategory() {
        return category;
    }

    // Setter for price
    public void setPrice(double price) {
        this.price = price;
    }

    // Setter for category
    public void setCategory(String category) {
        this.category = category;
    }

    // Override toString method to provide a custom string representation of Books
    @Override
    public String toString() {
        return "Books [price=" + price + ", category=" + category + "]";
    }
}

// Clothing class that extends Product
class Clothing extends Product {
    private String material; // Material of the clothing

    // Constructor to initialize price and material
    public Clothing(double price, String material) {
        this.price = price;
        this.material = material;
    }

    // Getter for material
    public String getMaterial() {
        return material;
    }

    // Setter for material
    public void setMaterial(String material) {
        this.material = material;
    }

    // Getter for price
    public double getPrice() {
        return price;
    }

    // Setter for price
    public void setPrice(double price) {
        this.price = price;
    }

    // Override toString method to provide a custom string representation of Clothing
    @Override
    public String toString() {
        return "Clothing [price=" + price + ", material =" + material + "]";
    }
}

// Gadgets class that extends Product
class Gadgets extends Product {
    private String gadgetName; // Name of the gadget

    // Constructor to initialize price and gadgetName
    public Gadgets(double price, String gadgetName) {
        this.price = price;
        this.gadgetName = gadgetName;
    }

    // Getter for gadgetName
    public String getGadgetName() {
        return gadgetName;
    }

    // Setter for gadgetName
    public void setGadgetName(String gadgetName) {
        this.gadgetName = gadgetName;
    }

    // Getter for price
    public double getPrice() {
        return price;
    }

    // Setter for price
    public void setPrice(double price) {
        this.price = price;
    }

    // Override toString method to provide a custom string representation of Gadgets
    @Override
    public String toString() {
        return "Gadgets [price=" + price + ", Gadget=" + gadgetName + "]";
    }
}

// Generic Product class with a method to apply discounts
class Product<T extends Product> {
    double price; // Price of the product

    // Method to apply discount to the product
    public void applyDiscount(Product<T> product, double percentage) {
        // Calculate the discounted price
        double discountedPrice = product.price * (1 - percentage / 100);
        product.price = discountedPrice; // Update the product's price with the discounted value
    }
}

public class OnlineMarketPlace {
    public static void main(String[] args) {
        // Create instances of Books, Clothing, and Gadgets with their prices
        Product<Books> books1 = new Books(1500.00, "Novels");
        Product<Clothing> clothing1 = new Clothing(2222.00, "Cotton");
        Product<Gadgets> gadgets1 = new Gadgets(113200.00, "Laptop");

        // Display the initial product information (before discount)
        System.out.println("Initial Price:");
        System.out.println(books1);
        System.out.println(clothing1);
        System.out.println(gadgets1);

        // Apply a 10% discount to each product
        books1.applyDiscount(books1, 10.0);
        clothing1.applyDiscount(clothing1, 10.0);
        gadgets1.applyDiscount(gadgets1, 10.0);
        System.out.println();

        // Display the updated product information (after discount)
        System.out.println("Updated Price After 10% Discount:");
        System.out.println(books1);
        System.out.println(clothing1);
        System.out.println(gadgets1);
    }
}