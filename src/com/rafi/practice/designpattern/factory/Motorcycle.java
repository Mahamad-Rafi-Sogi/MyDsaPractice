package com.rafi.practice.designpattern.factory;

public class Motorcycle implements Vehicle {

    private String type;
    private int engineCC;
    
    public Motorcycle(int engineCC) {
        this.type = "Motorcycle";
        this.engineCC = engineCC;
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
