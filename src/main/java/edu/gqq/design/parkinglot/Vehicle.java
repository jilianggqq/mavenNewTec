package edu.gqq.design.parkinglot;

public abstract class Vehicle {
	protected String plate;
	
	protected Size size;

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}
	
	
}
