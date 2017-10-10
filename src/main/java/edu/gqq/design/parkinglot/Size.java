package edu.gqq.design.parkinglot;

public enum Size {
	Small(0), Medium(1), Large(2), XLarge(3);

	private int value;

	Size(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
