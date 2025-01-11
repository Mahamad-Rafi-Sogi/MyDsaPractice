package com.rafi.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Producer2 implements Runnable {
    private final List<Integer> list;
    private final int MAX_CAPACITY;
    private int count = 0;

    public Producer2(List<Integer> list, int maxCapacity) {
        this.list = list;
        this.MAX_CAPACITY = maxCapacity;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                while (list.size() == MAX_CAPACITY) {
                    try {
                        list.wait(); // Wait if the list is full
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Producing: " + count);
                list.add(count++);
                list.notify(); // Notify the consumer
                try {
                    Thread.sleep(1000); // Simulate production delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Consumer2 implements Runnable {
    private final List<Integer> list;

    public Consumer2(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                while (list.isEmpty()) {
                    try {
                        list.wait(); // Wait if the list is empty
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int value = list.remove(0);
                System.out.println("Consuming: " + value);
                list.notify(); // Notify the producer
                try {
                    Thread.sleep(1000); // Simulate consumption delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class ThreadExampleWithExecutor {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int maxCapacity = 1; // Maximum capacity of the list

        // Use ExecutorService to manage threads
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(new Producer(list, maxCapacity));
        executorService.execute(new Consumer(list));

        // The executor will run indefinitely as the producer and consumer are in infinite loops.
        // To shut it down gracefully after a certain condition, you can call executorService.shutdown().
    }
}