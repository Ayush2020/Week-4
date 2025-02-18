package org.Capgemini.Reflections.SimpleDIContainer;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@interface Inject {

}


class DIContainer {
    private Map<Class<?>, Object> instances = new HashMap<>();

    public void register(Class<?> clazz) {
        try {
            Object instance = clazz.getDeclaredConstructor().newInstance();
            instances.put(clazz, instance);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create instance of " + clazz.getName(), e);
        }
    }

    public <T> T getInstance(Class<T> clazz) {
        return clazz.cast(instances.get(clazz));
    }

    public void injectDependencies() {
        for (Object instance : instances.values()) {
            for (Field field : instance.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(Inject.class)) {
                    Class<?> fieldType = field.getType();
                    Object dependency = instances.get(fieldType);
                    if (dependency != null) {
                        field.setAccessible(true);
                        try {
                            field.set(instance, dependency);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException("Failed to inject dependency into " + instance.getClass().getName(), e);
                        }
                    }
                }
            }
        }
    }
}
class ServiceA {
    public void doSomething() {
        System.out.println("ServiceA is doing something.");
    }
}

class ServiceB {
    @Inject
    private ServiceA serviceA;

    public void doSomething() {
        serviceA.doSomething();
        System.out.println("ServiceB is doing something.");
    }
}
public class SimpleDIContainer {
    public static void main(String[] args) {
        DIContainer container = new DIContainer();

        // Register classes
        container.register(ServiceA.class);
        container.register(ServiceB.class);

        // Inject dependencies
        container.injectDependencies();

        // Retrieve an instance and use it
        ServiceB serviceB = container.getInstance(ServiceB.class);
        serviceB.doSomething();
    }
}