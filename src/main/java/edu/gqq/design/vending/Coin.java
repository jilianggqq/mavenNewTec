package edu.gqq.design.vending;

public enum Coin {
	Penney(1), Nickel(5), Dime(10), Quarter(25);
	private int denomination;

	Coin(int denomination) {
		this.denomination = denomination;
	}

	public int getDenomination() {
		return denomination;
	}
}
