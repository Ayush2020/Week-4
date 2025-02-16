package org.Capgemini.JUnit.TaskUtils;

public class TaskUtils {

    // Simulate a long-running task that sleeps for 3 seconds
    public String longRunningTask() throws InterruptedException {
        Thread.sleep(3000); // Sleep for 3 seconds (3000 milliseconds)
        return "Task Completed";
    }
}
