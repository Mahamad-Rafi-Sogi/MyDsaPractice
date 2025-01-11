package com.rafi.practice;

import java.util.ArrayList;
import java.util.List;

class Producer implements Runnable {
    private final List<Integer> list;
    private final int MAX_CAPACITY;
    private int count = 0;

    public Producer(List<Integer> list, int maxCapacity) {
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

class Consumer implements Runnable {
    private final List<Integer> list;

    public Consumer(List<Integer> list) {
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

public class ThreadExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int maxCapacity = 1; // Maximum capacity of the list

        Thread producer = new Thread(new Producer(list, maxCapacity));
        Thread consumer = new Thread(new Consumer(list));

        producer.start();
        consumer.start();
    }
}