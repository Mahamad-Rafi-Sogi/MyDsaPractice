package com.rafi.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        // Create a fixed thread pool with 3 threads
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Submitting tasks to the executor
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            executorService.execute(() -> {
                System.out.println("Executing Task " + taskId + " by " + Thread.currentThread().getName());
            });
        }

        // Shutdown the executor after task execution
        executorService.shutdown();
    }
}