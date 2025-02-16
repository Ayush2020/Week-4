package org.Capgemini.JUnit.TaskUtils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class TaskUtilsTest {

    private TaskUtils taskUtils = new TaskUtils();

    // Test with a timeout of 2 seconds
    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS) // Fail if the test takes more than 2 seconds
    public void testLongRunningTask() throws InterruptedException {
        String result = taskUtils.longRunningTask(); // This will take 3 seconds
        assertEquals("Task Completed", result, "The result should be 'Task Completed'");
    }
}
