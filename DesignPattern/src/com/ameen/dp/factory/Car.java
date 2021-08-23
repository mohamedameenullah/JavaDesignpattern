package com.ameen.dp.factory;

public class Car extends Vehicle{
	private int wheels;
	public Car(int wheels) {
		this.wheels = wheels;
	}
	@Override
	public int getNoOfWheels() {
		System.err.println("Car instance");
		return wheels;
	}
}