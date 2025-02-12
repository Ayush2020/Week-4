package org.Capgemini.javaGenerics.Problem4MealPlanGenerator;

// Interface representing a generic meal plan
interface MealPlan {
    String getMealCategory(); // Method to get the category of the meal
    String getMealDetails(); // Method to get meal details
}

// Vegetarian Meal Plan implementation
class VegetarianMeal implements MealPlan {
    @Override
    public String getMealCategory() {
        return "Vegetarian Meal";
    }

    @Override
    public String getMealDetails() {
        return "A meal based on plant-based ingredients, no meat.";
    }
}

// Vegan Meal Plan implementation
class VeganMeal implements MealPlan {
    @Override
    public String getMealCategory() {
        return "Vegan Meal";
    }

    @Override
    public String getMealDetails() {
        return "A meal based on plant-based ingredients, excluding all animal products.";
    }
}

// Keto Meal Plan implementation
class KetoMeal implements MealPlan {
    @Override
    public String getMealCategory() {
        return "Keto Meal";
    }

    @Override
    public String getMealDetails() {
        return "A low-carb, high-fat meal plan designed to put the body in ketosis.";
    }
}

// High-Protein Meal Plan implementation
class HighProteinMeal implements MealPlan {
    @Override
    public String getMealCategory() {
        return "High-Protein Meal";
    }

    @Override
    public String getMealDetails() {
        return "A meal plan designed to support muscle growth with high-protein foods.";
    }
}

// Generic class to manage personalized meal plans
class Meal<T extends MealPlan> {
    private String userName; // Name of the user
    private T mealPlan; // The meal plan (of type T which extends MealPlan)

    // Constructor to initialize the user's name and selected meal plan
    public Meal(String userName, T mealPlan) {
        this.userName = userName;
        this.mealPlan = mealPlan;
    }

    // Method to display meal plan details
    public void showMealPlan() {
        System.out.println("Personalized Meal Plan for " + userName + ":");
        System.out.println(mealPlan.getMealCategory() + " - " + mealPlan.getMealDetails());
    }

    // Generic method to validate and generate a meal plan
    public static <T extends MealPlan> boolean validateMealPlan(T mealPlan) {
        // Basic validation: checking if the meal plan is null (could be extended for more complex validation)
        if (mealPlan == null) {
            System.out.println("Invalid meal plan selection!");
            return false;
        }
        // If meal plan is valid, print validation success and return true
        System.out.println("Meal plan is valid: " + mealPlan.getMealCategory());
        return true;
    }
}

public class MealPlanGenerator {
    public static void main(String[] args) {
        // Creating different types of meal plans
        Meal<VegetarianMeal> vegetarianMeal = new Meal<>("John", new VegetarianMeal());
        Meal<VeganMeal> veganMeal = new Meal<>("Sarah", new VeganMeal());
        Meal<KetoMeal> ketoMeal = new Meal<>("Mike", new KetoMeal());
        Meal<HighProteinMeal> highProteinMeal = new Meal<>("Anna", new HighProteinMeal());

        // Validating and displaying personalized meal plans for each user
        System.out.println("\nMeal Plan Validation and Details:\n");

        vegetarianMeal.showMealPlan();
        System.out.println();

        veganMeal.showMealPlan();
        System.out.println();

        ketoMeal.showMealPlan();
        System.out.println();

        highProteinMeal.showMealPlan();

    }
}