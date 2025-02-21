package com.rafi.practice;

import java.util.*;

public class ProducerConsumerWithList {
    public static void main(String[] args) {
        List<Integer> sharedList = new ArrayList<>(); // Shared list
        final int CAPACITY = 5; // Maximum size of the list

        // Producer Thread
        Thread producer = new Thread(() -> {
            int count = 1;
            while (true) {
                synchronized (sharedList) {
                    while (sharedList.size() == CAPACITY) {
                        try {
                            sharedList.wait(); // Wait if the list is full
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Produced: " + count);
                    sharedList.add(count++);
                    sharedList.notify(); // Notify consumer
                }
                sleep(500); // Simulating some delay
            }
        });

        // Consumer Thread
        Thread consumer = new Thread(() -> {
            while (true) {
                synchronized (sharedList) {
                    while (sharedList.isEmpty()) {
                        try {
                            sharedList.wait(); // Wait if the list is empty
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int value = sharedList.remove(0);
                    System.out.println("Consumed: " + value);
                    sharedList.notify(); // Notify producer
                }
                sleep(1000); // Simulating processing delay
            }
        });

        producer.start();
        consumer.start();
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}