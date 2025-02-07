package com.rafi.practice.designpattern.factory;

public class Car implements Vehicle {

    private String type;
    private String engineType;
    
    public Car(String engineType) {
        this.type = "Car";
        this.engineType = engineType;
    }
    
	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

	@Override
	public void accelerate() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}

}
