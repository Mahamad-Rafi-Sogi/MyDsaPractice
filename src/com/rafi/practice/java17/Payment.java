package com.rafi.practice.java17;


//Base class with restricted inheritance
sealed interface Payment permits CreditCardPayment, PayPalPayment { 
 abstract void processPayment();

}