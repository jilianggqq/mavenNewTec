package edu.gqq.design.jukebox;

/**
 * how to implement enum;
 * @author itu
 *
 */
public enum Suit {
	Clubs(0), Diamonds(1), Heart(2), Spades(3);

	private int val;

	Suit(int val) {
		this.val = val;
	}

	public int getVal() {
		return val;
	}

}
