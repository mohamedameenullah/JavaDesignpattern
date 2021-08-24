package com.ameen.dp.builder;

public class BuilderPatternExample {
	public static void main(String[] args) {
		Vehicle car = new Vehicle.VehicleBuilder(4, "1500CC").setAirbags(4).setColor("Green").build();
		Vehicle Bike = new Vehicle.VehicleBuilder(2, "350CC").setColor("StealthBlack").build();

		System.out.println(car);
		System.out.println(Bike);
	}
}
