package com.rafi.practice.designpattern.abstractfactory;

public interface FurnitureFactory {
    Chair createChair();
    Table createTable();
    Sofa createSofa();
}