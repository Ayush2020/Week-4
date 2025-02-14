package org.Capgemini.JavaStreams.PipedStream;

import java.io.*;

class WriterThread extends Thread {
    private PipedOutputStream pipedOutputStream;

    // Constructor to initialize the PipedOutputStream
    public WriterThread(PipedOutputStream pipedOutputStream) {
        this.pipedOutputStream = pipedOutputStream;
    }

    @Override
    public void run() {
        try {
            // Simulating writing data into the PipedOutputStream
            String data = "Hello from WriterThread!";
            pipedOutputStream.write(data.getBytes());
            System.out.println("WriterThread: Data written to pipe");
        } catch (IOException e) {
            System.out.println("WriterThread: IOException occurred: " + e.getMessage());
        } finally {
            // Close the stream after writing
            try {
                pipedOutputStream.close();
            } catch (IOException e) {
                System.out.println("WriterThread: Error closing the PipedOutputStream: " + e.getMessage());
            }
        }
    }
}

class ReaderThread extends Thread {
    private PipedInputStream pipedInputStream;

    // Constructor to initialize the PipedInputStream
    public ReaderThread(PipedInputStream pipedInputStream) {
        this.pipedInputStream = pipedInputStream;
    }

    @Override
    public void run() {
        try {
            // Read data from the PipedInputStream
            int data;
            StringBuilder sb = new StringBuilder();
            while ((data = pipedInputStream.read()) != -1) {
                sb.append((char) data);
            }
            System.out.println("ReaderThread: Data received from pipe: " + sb.toString());
        } catch (IOException e) {
            System.out.println("ReaderThread: IOException occurred: " + e.getMessage());
        } finally {
            // Close the stream after reading
            try {
                pipedInputStream.close();
            } catch (IOException e) {
                System.out.println("ReaderThread: Error closing the PipedInputStream: " + e.getMessage());
            }
        }
    }
}

public class PipedStream {
    public static void main(String[] args) {
        // Create PipedOutputStream and PipedInputStream
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        PipedInputStream pipedInputStream = null;

        try {
            // Connect PipedInputStream to PipedOutputStream
            pipedInputStream = new PipedInputStream(pipedOutputStream);

            // Create threads for writing and reading
            WriterThread writerThread = new WriterThread(pipedOutputStream);
            ReaderThread readerThread = new ReaderThread(pipedInputStream);

            // Start both threads
            writerThread.start();
            readerThread.start();

            // Wait for both threads to finish
            writerThread.join();
            readerThread.join();

        } catch (IOException | InterruptedException e) {
            System.out.println("Main: Exception occurred: " + e.getMessage());
        } finally {
            try {
                if (pipedInputStream != null) {
                    pipedInputStream.close();
                }
            } catch (IOException e) {
                System.out.println("Main: Error closing the PipedInputStream: " + e.getMessage());
            }
        }
    }
}
