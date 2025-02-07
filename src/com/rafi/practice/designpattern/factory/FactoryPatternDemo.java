package com.rafi.practice.designpattern.factory;

public class FactoryPatternDemo {

    public static void main(String[] args) {
        try {
            // Create different types of vehicles using the factory
            Vehicle car = VehicleFactory.createVehicle("car", "Hybrid");
            Vehicle motorcycle = VehicleFactory.createVehicle("motorcycle", 1000);
            Vehicle bicycle = VehicleFactory.createVehicle("bicycle", "Mountain");
            
            // Test car
            System.out.println("\n=== Testing " + car.getType() + " ===");
            car.start();
            car.accelerate();
            car.stop();
            
            // Test motorcycle
            System.out.println("\n=== Testing " + motorcycle.getType() + " ===");
            motorcycle.start();
            motorcycle.accelerate();
            motorcycle.stop();
            
            // Test bicycle
            System.out.println("\n=== Testing " + bicycle.getType() + " ===");
            bicycle.start();
            bicycle.accelerate();
            bicycle.stop();
            
            // Try to create an invalid vehicle type
            Vehicle invalid = VehicleFactory.createVehicle("airplane");
            
        } catch (IllegalArgumentException e) {
            System.out.println("\nError: " + e.getMessage());
        }
    }

}
