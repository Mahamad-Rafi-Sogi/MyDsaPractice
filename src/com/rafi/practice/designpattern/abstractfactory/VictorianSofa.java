package com.rafi.practice.designpattern.abstractfactory;

public class VictorianSofa implements Sofa {
    @Override
    public void lieDown() {
        System.out.println("Lying down on a velvet Victorian sofa with tufted design");
    }
    
    @Override
    public String getStyle() {
        return "Victorian";
    }
}