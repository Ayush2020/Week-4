package org.Capgemini.JavaCollections.MapInterface.ShoppingCart;

import java.util.*;

public class ShoppingCart {

    // HashMap to store product names and their prices
    private Map<String, Double> productPrices = new HashMap<>();
    // LinkedHashMap to maintain the order of items added to the cart
    private Map<String, Integer> cart = new LinkedHashMap<>();
    // TreeMap to display items sorted by price
    private Map<String, Double> sortedByPrice = new TreeMap<>();

    // Method to add a product to the product list
    public void addProduct(String productName, double price) {
        productPrices.put(productName, price);
    }

    // Method to add a product to the shopping cart
    public void addToCart(String productName, int quantity) {
        if (productPrices.containsKey(productName)) {
            cart.put(productName, quantity);
        } else {
            System.out.println("Product not available: " + productName);
        }
    }

    // Method to remove a product from the shopping cart
    public void removeFromCart(String productName) {
        if (cart.containsKey(productName)) {
            cart.remove(productName);
        } else {
            System.out.println("Product not in cart: " + productName);
        }
    }

    // Method to view the cart in the order items were added
    public void viewCart() {
        System.out.println("Shopping Cart (Insertion Order):");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String productName = entry.getKey();
            int quantity = entry.getValue();
            double price = productPrices.get(productName);
            double total = price * quantity;
            System.out.println(productName + " -> Quantity: " + quantity + ", Price: " + price + ", Total: " + total);
        }
    }

    // Method to view the cart sorted by product price
    public void viewCartSortedByPrice() {
        System.out.println("\nShopping Cart (Sorted by Price):");
        // Adding products to TreeMap, sorted by price
        sortedByPrice.clear(); // Clear any existing entries in TreeMap
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String productName = entry.getKey();
            int quantity = entry.getValue();
            double price = productPrices.get(productName);
            sortedByPrice.put(productName, price);
        }
        // Displaying sorted products
        for (Map.Entry<String, Double> entry : sortedByPrice.entrySet()) {
            String productName = entry.getKey();
            double price = entry.getValue();
            int quantity = cart.get(productName);
            double total = price * quantity;
            System.out.println(productName + " -> Quantity: " + quantity + ", Price: " + price + ", Total: " + total);
        }
    }

    // Method to calculate the total price of the items in the cart
    public void calculateTotal() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String productName = entry.getKey();
            int quantity = entry.getValue();
            double price = productPrices.get(productName);
            total += price * quantity;
        }
        System.out.println("\nTotal Price of Cart: " + total);
    }

    // Main method to simulate the shopping cart system
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        // Adding products with their prices
        shoppingCart.addProduct("Apple", 1.5);
        shoppingCart.addProduct("Banana", 0.8);
        shoppingCart.addProduct("Orange", 1.2);
        shoppingCart.addProduct("Milk", 2.5);
        shoppingCart.addProduct("Bread", 1.0);

        // Adding items to the cart
        shoppingCart.addToCart("Apple", 3);
        shoppingCart.addToCart("Banana", 5);
        shoppingCart.addToCart("Milk", 2);
        shoppingCart.addToCart("Bread", 1);

        // Viewing the cart in the order items were added
        shoppingCart.viewCart();

        // Viewing the cart sorted by price
        shoppingCart.viewCartSortedByPrice();

        // Calculating total price
        shoppingCart.calculateTotal();

        // Removing an item from the cart
        shoppingCart.removeFromCart("Banana");

        // Viewing the cart again after removal
        shoppingCart.viewCart();
    }
}

