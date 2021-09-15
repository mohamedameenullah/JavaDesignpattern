package com.ameen.dp.factory;

public abstract class Vehicle {
	public abstract int getNoOfWheels();

	public String toString() {
		return "Wheel ---- " + getNoOfWheels();
	}

}
