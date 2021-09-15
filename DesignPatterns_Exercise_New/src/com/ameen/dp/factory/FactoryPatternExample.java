package com.ameen.dp.factory;

public class FactoryPatternExample {
	public static void main(String[] args) {
		Vehicle car = VehicleFactory.getInstance("car", 4);
		System.out.println(car);
		
		Bike bike = (Bike) VehicleFactory.getInstance("bike", 2);
		System.out.println(bike);
		
	}
}
