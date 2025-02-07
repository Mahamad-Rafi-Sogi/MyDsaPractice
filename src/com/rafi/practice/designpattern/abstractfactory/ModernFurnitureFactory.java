package com.rafi.practice.designpattern.abstractfactory;

public class ModernFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ModernChair();
    }
    
    @Override
    public Table createTable() {
        return new ModernTable();
    }
    
    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }
}