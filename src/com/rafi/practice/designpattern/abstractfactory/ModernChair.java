package com.rafi.practice.designpattern.abstractfactory;

public class ModernChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Sitting on a sleek, minimalist Modern chair");
    }
    
    @Override
    public String getStyle() {
        return "Modern";
    }
}