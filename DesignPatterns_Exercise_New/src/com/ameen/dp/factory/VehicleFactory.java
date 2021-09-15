package com.ameen.dp.factory;

public class VehicleFactory {
	public static Vehicle getInstance(String type, int wheels) {
		switch (type) {
		case "car":
			return new Car(wheels);
		case "bike":
			return new Bike(wheels);
		default:
			break;
		}
		return null;
	}
}
