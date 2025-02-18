package org.Capgemini.Annotations.CacheAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// Define the @CacheResult annotation
@Target(ElementType.METHOD) // Can be applied to methods
@Retention(RetentionPolicy.RUNTIME) // Retained at runtime for reflection
@interface CacheResult {
}

// Custom Cache class to store method results
class Cache {
    private final Map<String, Object> cache = new HashMap<>();

    // Get the cached result for a given key
    public Object get(String key) {
        return cache.get(key);
    }

    // Put a result into the cache with a given key
    public void put(String key, Object result) {
        cache.put(key, result);
    }
}

// Class with computationally expensive methods
class ExpensiveComputation {

    private Cache cache = new Cache(); // Instance of the custom cache

    // Simulate an expensive computation and cache the result
    @CacheResult
    public int expensiveMethod(int input) {
        // First, check if the result is already cached
        String cacheKey = "expensiveMethod_" + input;
        Object cachedResult = cache.get(cacheKey);
        if (cachedResult != null) {
            System.out.println("Cache hit for input: " + input);
            return (int) cachedResult; // Return the cached result
        }

        // Simulate an expensive computation (e.g., a long-running calculation)
        System.out.println("Cache miss for input: " + input);
        int result = input * input; // Just an example computation

        // Cache the result for future calls
        cache.put(cacheKey, result);

        return result;
    }
}

// Main class to test caching
public class CustomCache {

    // Method to invoke the annotated method and apply caching
    public static Object invokeWithCache(ExpensiveComputation obj, Method method, Object[] args) throws Exception {
        if (method.isAnnotationPresent(CacheResult.class)) {
            // Check if the result is already cached by calling the method in ExpensiveComputation class
            return method.invoke(obj, args);
        }
        return method.invoke(obj, args); // If no cache, just invoke the method
    }

    public static void main(String[] args) throws Exception {
        ExpensiveComputation expensiveComputation = new ExpensiveComputation();

        // Get the method reference for expensiveMethod
        Method expensiveMethod = ExpensiveComputation.class.getDeclaredMethod("expensiveMethod", int.class);

        // Test method with the same input twice to see caching in action
        System.out.println("Result 1: " + invokeWithCache(expensiveComputation, expensiveMethod, new Object[]{5}));
        System.out.println("Result 2: " + invokeWithCache(expensiveComputation, expensiveMethod, new Object[]{5}));
        System.out.println("Result 3: " + invokeWithCache(expensiveComputation, expensiveMethod, new Object[]{10}));
        System.out.println("Result 4: " + invokeWithCache(expensiveComputation, expensiveMethod, new Object[]{5}));
    }
}
