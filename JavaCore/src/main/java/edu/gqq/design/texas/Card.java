package edu.gqq.design.texas;

import java.util.Comparator;

public class Card {
	private short rank, suit;

	private static String[] ranks = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
	private static String[] suits = { "Diamonds", "Clubs", "Hearts", "Spades" };

	// Constructor
	public Card(short rank, short suit) {
		this.rank = rank;
		this.suit = suit;
	}

	// Getter and Setters
	public short getSuit() {
		return suit;
	}

	public short getRank() {
		return rank;
	}

	protected void setSuit(short suit) {
		this.suit = suit;
	}

	protected void setRank(short rank) {
		this.rank = rank;
	}

	// methods
	public static String rankAsString(int __rank) {
		return ranks[__rank];
	}

	public static String suitAsString(int __suit) {
		return suits[__suit];
	}

	@Override
	public String toString() {
		return rank + " of " + suit;
	}

	// Print card to string
	protected String printCard() {
		return ranks[rank] + " of " + suits[suit];
	}

	// Determine if two cards are the same (Ace of Diamonds == Ace of Diamonds)
	public static boolean sameCard(Card card1, Card card2) {
		return (card1.rank == card2.rank && card1.suit == card2.suit);
	}
}

class rankComparator implements Comparator<Card> {
	public int compare(Card card1, Card card2) throws ClassCastException {
		// verify two Card objects are passed in
		return card1.getRank() - card2.getRank();
	}
}

class suitComparator implements Comparator<Card> {
	public int compare(Card card1, Card card2) throws ClassCastException {
		// verify two Card objects are passed in
		return card1.getSuit() - card2.getSuit();
	}
}
