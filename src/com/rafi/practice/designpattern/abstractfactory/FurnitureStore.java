package com.rafi.practice.designpattern.abstractfactory;

public class FurnitureStore {
    private FurnitureFactory factory;
    
    public FurnitureStore(FurnitureFactory factory) {
        this.factory = factory;
    }
    
    public void orderFurnitureSet() {
        Chair chair = factory.createChair();
        Table table = factory.createTable();
        Sofa sofa = factory.createSofa();
        
        System.out.println("\nOrdering a " + chair.getStyle() + " style furniture set:");
        chair.sitOn();
        table.placeItem();
        sofa.lieDown();
    }
}