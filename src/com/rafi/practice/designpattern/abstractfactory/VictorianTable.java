package com.rafi.practice.designpattern.abstractfactory;

public class VictorianTable implements Table {
    @Override
    public void placeItem() {
        System.out.println("Placing item on a wooden Victorian table with intricate patterns");
    }
    
    @Override
    public String getStyle() {
        return "Victorian";
    }
}