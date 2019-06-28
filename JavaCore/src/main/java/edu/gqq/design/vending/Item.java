package edu.gqq.design.vending;

/**
 * You must know how to implement an enum.
 * @author gqq
 *
 */
public enum Item {

	Coke("Coke", 25), Pepsi("Pepsi", 35), Soda("Soda", 45);

	private String desc;
	private int price;

	Item(String desc, int price) {
		this.desc = desc;
		this.price = price;
	}

	public String getDesc() {
		return this.desc;
	}

	public int getPrice() {
		return this.price;
	}
}
