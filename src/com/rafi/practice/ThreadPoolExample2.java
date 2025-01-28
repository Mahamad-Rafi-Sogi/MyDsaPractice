package com.rafi.practice;

import java.util.concurrent.*;
import java.util.Queue;
import java.util.LinkedList;

public class ThreadPoolExample2 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        
        Queue<Integer> sharedQueue = new LinkedList<>();
        int MAX_CAPACITY = 5;

  
        Runnable producer = () -> {
            int taskId = 1;
            while (taskId <= 10) {
                synchronized (sharedQueue) {
                    while (sharedQueue.size() == MAX_CAPACITY) {
                        try {
                            sharedQueue.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println("Produced: " + taskId);
                    sharedQueue.add(taskId++);
                    sharedQueue.notifyAll();
                }
                try {
                    Thread.sleep(1000); 
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

      
        Runnable consumer = () -> {
            while (true) {
                synchronized (sharedQueue) {
                    while (sharedQueue.isEmpty()) {
                        try {
                            sharedQueue.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return; 
                        }
                    }
                    int taskId = sharedQueue.poll();
                    System.out.println("Consumed: " + taskId);
                    sharedQueue.notifyAll();
                }
                try {
                    Thread.sleep(1000); 
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return; 
                }
            }
        };

      
        executor.execute(producer);
        executor.execute(consumer);
       
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.schedule(() -> {
            System.out.println("Shutting down executor...");
            executor.shutdownNow();
            scheduler.shutdown();
        }, 10, TimeUnit.SECONDS);
    }
}