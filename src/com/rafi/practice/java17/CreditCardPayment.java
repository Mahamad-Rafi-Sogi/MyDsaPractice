package com.rafi.practice.java17;

//Only these subclasses can extend Payment
final class CreditCardPayment implements Payment {
 public void processPayment() {
     System.out.println("Processing Credit Card Payment...");
 }
}