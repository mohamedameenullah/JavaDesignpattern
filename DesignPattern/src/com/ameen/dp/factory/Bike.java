package com.ameen.dp.factory;

public class Bike extends Vehicle{
	private int wheels;
	public Bike(int wheels) {
		System.err.println("This is Bike instance.");
		this.wheels = wheels;
	}
	@Override
	public int getNoOfWheels() {
		return wheels;
	}
}