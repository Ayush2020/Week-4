package org.Capgemini.JUnit.FileProcessor;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.File;
import java.io.IOException;

public class FileProcessorTest {

    private FileProcessor fileProcessor;

    // Set up method to initialize the fileProcessor object before each test
    @BeforeEach
    public void setUp() {
        fileProcessor = new FileProcessor();
    }

    // Test to verify that the content is written and read correctly
    @Test
    public void testWriteAndReadFile() throws IOException {
        String filename = "testfile.txt";
        String content = "Hello, world!";

        // Write to file
        fileProcessor.writeToFile(filename, content);

        // Read from file
        String readContent = fileProcessor.readFromFile(filename);

        // Verify the content is written and read correctly
        assertEquals(content, readContent, "The content read from the file should match the written content.");

        // Clean up by deleting the test file
        new File(filename).delete();
    }

    // Test to verify that the file exists after writing content
    @Test
    public void testFileExistsAfterWriting() throws IOException {
        String filename = "testfile.txt";
        String content = "This file should exist.";

        // Write to file
        fileProcessor.writeToFile(filename, content);

        // Verify the file exists
        File file = new File(filename);
        assertTrue(file.exists(), "The file should exist after writing.");

        // Clean up by deleting the test file
        file.delete();
    }

    // Test to handle IOException when the file does not exist
    @Test
    public void testFileNotFoundException() {
        String filename = "nonexistentfile.txt";

        // Try reading from a file that does not exist
        assertThrows(IOException.class, () -> {
            fileProcessor.readFromFile(filename);
        }, "An IOException should be thrown when the file does not exist.");
    }

    // Clean up method after all tests
    @AfterEach
    public void tearDown() {
        // Any cleanup logic can be added here if needed
    }
}
