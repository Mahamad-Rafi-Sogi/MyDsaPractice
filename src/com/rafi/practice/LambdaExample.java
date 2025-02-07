package com.rafi.practice;

public class LambdaExample {
    public static void main(String[] args) {
        // Implement the MathOperation interface using a lambda expression
        MathOperation addition = (a, b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;
        MathOperation multiplication = (a, b) -> a * b;
        MathOperation division = (a, b) -> a / b;

        // Use the functional interface
        System.out.println("Addition: " + addition.operate(10, 5));        // Output: 15
        System.out.println("Subtraction: " + subtraction.operate(10, 5)); // Output: 5
        System.out.println("Multiplication: " + multiplication.operate(10, 5)); // Output: 50
        System.out.println("Division: " + division.operate(10, 5));       // Output: 2
        
    }
}
