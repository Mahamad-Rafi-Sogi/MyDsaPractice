package com.rafi.practice.designpattern.factory;

public class Bicycle implements Vehicle {
	
    private String type;
    private String bikeType;
    
    public Bicycle(String bikeType) {
        this.type = "Bicycle";
        this.bikeType = bikeType;
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
