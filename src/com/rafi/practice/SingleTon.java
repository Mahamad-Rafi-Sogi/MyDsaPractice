package com.rafi.practice;

public class SingleTon {

    // Private static instance
    private static SingleTon singleton;

    // Private constructor to prevent instantiation
    private SingleTon() {
        System.out.println("Singleton Instance Created!");
    }
    
    // Public static method to provide the global access point
    public static SingleTon getInstance() {
        if (singleton == null) {
            synchronized (SingleTon.class) { // Thread-safe implementation
                if (singleton == null) {
                    singleton = new SingleTon();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        // Get Singleton instances
        SingleTon s1 = SingleTon.getInstance();
        SingleTon s2 = SingleTon.getInstance();

        // Verify if both instance	s are the same
        System.out.println("Are both instances the same? " + (s1 == s2));
    }
}