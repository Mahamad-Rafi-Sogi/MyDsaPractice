package com.rafi.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            executor.execute(() -> {
                System.out.println("Task " + taskId + " is running by " + Thread.currentThread().getName());
            });
        }
        System.out.println( executor.isTerminated() );
        System.out.println( executor.isShutdown() );
        executor.shutdown();
    }
}
