package com.rafi.practice.designpattern.abstractfactory;

public class ModernSofa implements Sofa {
    @Override
    public void lieDown() {
        System.out.println("Lying down on a leather Modern sofa");
    }
    
    @Override
    public String getStyle() {
        return "Modern";
    }
}