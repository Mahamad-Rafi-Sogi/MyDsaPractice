package com.rafi.practice;

import java.io.Serializable;

public class SingleTon implements Serializable, Cloneable {

    // Private static instance
    private static volatile SingleTon singleton;

    // Private constructor to prevent instantiation
    private SingleTon() {
        if (singleton != null) {
            throw new RuntimeException("Use getInstance() method to create instance");
        }
        System.out.println("Singleton Instance Created!");
    }

    // Public static method to provide global access point (Thread-safe)
    public static SingleTon getInstance() {
        if (singleton == null) {
            synchronized (SingleTon.class) {
                if (singleton == null) {
                    singleton = new SingleTon();
                }
            }
        }
        return singleton;
    }

    // Prevent Serialization Breach
    protected Object readResolve() {
        return singleton;
    }

    // Prevent Cloning
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning is not allowed for Singleton");
    }

    public static void main(String[] args) throws Exception {
        // Get Singleton instances
        SingleTon s1 = SingleTon.getInstance();
        SingleTon s2 = SingleTon.getInstance();

        System.out.println("Are both instances the same? " + (s1 == s2));

        // Testing Cloning
        try {
            SingleTon clone = (SingleTon) s1.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not allowed: " + e.getMessage());
        }
    }
}