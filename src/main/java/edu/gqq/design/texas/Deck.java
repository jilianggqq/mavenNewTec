package edu.gqq.design.texas;

import java.util.Random;

public class Deck {
	private Card[] cards = new Card[52];

	// Constructor
	public Deck() {
		int i = 0;
		for (short j = 0; j < 4; j++) {
			for (short k = 0; k < 13; k++) {
				cards[i++] = new Card(k, j);
			}
		}
	}

	// Print entire deck in order
	protected void printDeck() {
		for (int i = 0; i < cards.length; i++) {
			System.out.println(i + 1 + ": " + cards[i].printCard());
		}
		System.out.println("\n");
	}

	// Find card in deck in a linear fashion
	// Use this method if deck is shuffled/random
	protected int findCard(Card card) {
		for (int i = 0; i < 52; i++) {
			if (Card.sameCard(cards[i], card)) {
				return i;
			}
		}
		return -1;
	}

	// return specified card from deck
	protected Card getCard(int cardNum) {
		return cards[cardNum];
	}

	protected void shuffle() {
		int length = cards.length;
		Random random = new Random();
		// random.nextInt();
		for (int i = 0; i < length; i++) {
			int change = i + random.nextInt(length - i);
			swapCards(i, change);
		}
	}

	protected void cutDeck() {
		Deck tempDeck = new Deck();
		Random random = new Random();
		int cutNum = random.nextInt(52);
		for (int i = 0; i < cutNum; i++) {
			tempDeck.cards[i] = this.cards[52 - cutNum + i];
		}
		for (int j = 0; j < 52 - cutNum; j++) {
			tempDeck.cards[j + cutNum] = this.cards[j];
		}
		this.cards = tempDeck.cards;
	}

	// Swap cards in array to 'shuffle' the deck.
	private void swapCards(int i, int change) {
		Card temp = cards[i];
		cards[i] = cards[change];
		cards[change] = temp;
	}
}