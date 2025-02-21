package com.rafi.practice.java17;

public class Main {
    public static void main(String[] args) {
        Payment payment1 = new CreditCardPayment();
        payment1.processPayment(); // Output: Processing Credit Card Payment...

        Payment payment2 = new PayPalPayment();
        payment2.processPayment(); // Output: Processing PayPal Payment...
    }
}