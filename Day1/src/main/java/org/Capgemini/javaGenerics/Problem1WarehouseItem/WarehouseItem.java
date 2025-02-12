package org.Capgemini.javaGenerics.Problem1WarehouseItem;

import java.util.ArrayList;
import java.util.List;

// Abstract class representing a generic warehouse item
abstract class WarehouseItems {
    // Name of the warehouse
    private final String warehouseName;
    // Address of the warehouse
    private final String warehouseAddress;

    // Constructor to initialize warehouse name and address
    public WarehouseItems(String warehouseName, String warehouseAddress) {
        this.warehouseName = warehouseName;
        this.warehouseAddress = warehouseAddress;
    }

    // Getter for warehouse name
    public String getWarehouseName() {
        return warehouseName;
    }

    // Getter for warehouse address
    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    // Override toString() to provide a string representation of the warehouse item
    @Override
    public String toString() {
        return "Warehouse Name: " + warehouseName + " Address: " + warehouseAddress;
    }
}

// Subclass representing Electronics items
class Electronics extends WarehouseItems {
    String brand; // Brand of the electronic item

    // Constructor to initialize Electronics item
    public Electronics(String warehouseName, String warehouseAddress, String brand) {
        super(warehouseName, warehouseAddress); // Call superclass constructor
        this.brand = brand;
    }

    // Override toString() to include brand information
    @Override
    public String toString() {
        return super.toString() + " Brand: " + brand;
    }
}

// Subclass representing Groceries items
class Groceries extends WarehouseItems {
    // Expiry date of the grocery item
    private String expiryDate;

    // Constructor to initialize Groceries item
    public Groceries(String warehouseName, String warehouseAddress, String expiryDate) {
        // Call superclass constructor
        super(warehouseName, warehouseAddress);
        this.expiryDate = expiryDate;
    }

    // Override toString() to include expiry date information
    @Override
    public String toString() {
        return super.toString() + " Expiry Date: " + expiryDate;
    }
}

// Subclass representing Furniture items
class Furniture extends WarehouseItems {
    // Material of the furniture item
    private String material;

    // Constructor to initialize Furniture item
    public Furniture(String warehouseName, String warehouseAddress, String material) {
        // Call superclass constructor
        super(warehouseName, warehouseAddress);
        this.material = material;
    }

    // Override toString() to include material information
    @Override
    public String toString() {
        return super.toString() + " Material: " + material;
    }
}

// Generic class to store warehouse items of a specific type
class Storage<E extends WarehouseItems> {
    // List to store items of type E
    private final List<E> warehouseItems;

    // Constructor to initialize the list
    Storage() {
        this.warehouseItems = new ArrayList<E>();
    }

    // Method to add an item to the storage
    public void add(E warehouseItem) {
        this.warehouseItems.add(warehouseItem);
    }

    // Method to remove an item from the storage
    public void remove(E warehouseItem) {
        this.warehouseItems.remove(warehouseItem);
    }

    // Method to display all items in the storage (uses wildcard for flexibility)
    public void getAllItems(List<? extends WarehouseItems> warehouseItems) {
        for (WarehouseItems item : warehouseItems) {
            System.out.println(item);
        }
    }

    // Getter to retrieve the list of warehouse items
    public List<E> getWarehouseItems() {
        return warehouseItems;
    }
}

// Main class to test the warehouse management system
public class WarehouseItem {
    public static void main(String[] args) {
        // Create storage for Electronics items
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.add(new Electronics("Asus India", "Delhi", "Asus"));

        // Create storage for Groceries items
        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.add(new Groceries("Starly Enterprises", "Bangalore", "18 March 2026"));

        // Create storage for Furniture items
        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.add(new Furniture("SleepWell", "Hyderabad", "Silicon Gold"));

        // Display all items in each storage
        System.out.println("Electronics Items:");
        electronicsStorage.getAllItems(electronicsStorage.getWarehouseItems());

        System.out.println("\nGroceries Items:");
        groceriesStorage.getAllItems(groceriesStorage.getWarehouseItems());

        System.out.println("\nFurniture Items:");
        furnitureStorage.getAllItems(furnitureStorage.getWarehouseItems());
    }
}
