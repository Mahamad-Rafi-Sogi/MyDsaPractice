package com.rafi.practice;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorExample {

    public static void main(String[] args) {
        // Create an executor instance
        Executor executor = Executors.newFixedThreadPool(2);

        // Submit tasks to the executor
        Runnable task1 = () -> {
        	while(true) {
            System.out.println("Task 1 is running on thread: " + Thread.currentThread().getName());
            try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	}
        	
        };

        Runnable task2 = () -> {
        	while(true) {
            System.out.println("Task 2 is running on thread: " + Thread.currentThread().getName());
            try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	}
        };

        executor.execute(task1);
        executor.execute(task2);

        // Since the executor is a SingleThreadExecutor, tasks will execute sequentially
    }
}
