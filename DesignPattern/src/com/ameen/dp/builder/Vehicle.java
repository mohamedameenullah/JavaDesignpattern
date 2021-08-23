package com.ameen.dp.builder;

public class Vehicle {
	// Required args
	private int noOfWheels;
	private String engine;

	// Optional args
	private String color;
	private int airbags;

	public int getNoOfWheels() {
		return noOfWheels;
	}

	public String getEngine() {
		return engine;
	}

	public String getColor() {
		return color;
	}

	public int getAirbags() {
		return airbags;
	}

	private Vehicle(VehicleBuilder builder) {
		this.noOfWheels = builder.noOfWheels;
		this.engine = builder.engine;
		this.color = builder.color;
		this.airbags = builder.airbags;
	}

	
	
	public static class VehicleBuilder {
		// Required args
		private int noOfWheels;
		private String engine;

		// Optional args
		private String color;
		private int airbags;

		VehicleBuilder(int noOfWheels, String engine) {
			this.noOfWheels = noOfWheels;
			this.engine = engine;
		}

		VehicleBuilder setColor(String color) {
			if (color != null) {
				this.color = color;
			} else {
				color = "Black";
			}
			return this;
		}

		VehicleBuilder setAirbags(int airbags) {
			this.airbags = airbags;
			return this;
		}

		public Vehicle build() {
			return new Vehicle(this);
		}

	}



	@Override
	public String toString() {
		return "Vehicle [noOfWheels=" + noOfWheels + ", engine=" + engine + ", color=" + color + ", airbags=" + airbags
				+ "]";
	}


}
