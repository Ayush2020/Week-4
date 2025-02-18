package org.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


interface Greeting {
    void sayHello();
}
class GreetingImpl implements Greeting {
    @Override
    public void sayHello() {
        System.out.println("Hello, World!");
    }
}


class LoggingInvocationHandler implements InvocationHandler {
    private final Object target;

    public LoggingInvocationHandler(Object target) {
        this.target = target; // Store the original object
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Log the method name before calling the actual method
        System.out.println("Method " + method.getName() + " is about to be called");

        // Invoke the actual method on the target object
        Object result = method.invoke(target, args);

        // Log after the method execution (if needed)
        System.out.println("Method " + method.getName() + " executed successfully");

        return result;
    }
}


public class ProxyNew {
    public static void main(String[] args) {
        // Create the original object (GreetingImpl)
        Greeting greeting = new GreetingImpl();

        // Create a logging proxy for the Greeting interface
        Greeting proxy = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(), // ClassLoader
                new Class[]{Greeting.class},     // Interface(s)
                new LoggingInvocationHandler(greeting) // Invocation Handler
        );

        // Call the method on the proxy object
        proxy.sayHello();
    }
}

