package com.rafi.practice.designpattern.abstractfactory;

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        // Create Modern Furniture Store
        System.out.println("=== Modern Furniture Store ===");
        FurnitureStore modernStore = new FurnitureStore(new ModernFurnitureFactory());
        modernStore.orderFurnitureSet();
        
        // Create Victorian Furniture Store
        System.out.println("\n=== Victorian Furniture Store ===");
        FurnitureStore victorianStore = new FurnitureStore(new VictorianFurnitureFactory());
        victorianStore.orderFurnitureSet();
        
        // Demonstrate individual product creation
        System.out.println("\n=== Individual Product Creation ===");
        FurnitureFactory modernFactory = new ModernFurnitureFactory();
        Chair modernChair = modernFactory.createChair();
        System.out.println("Created a " + modernChair.getStyle() + " chair");
        modernChair.sitOn();
    }
}