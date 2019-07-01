package edu.gqq.design;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.gqq.design.vending.Coin;

public class testEnum {
	@Test
	public void testCoins() throws Exception {
		Coin coin = Coin.Dime;
		assertEquals(coin.getDenomination(), 10);
		Coin coin2 = Coin.Nickel;
		assertEquals(coin2.getDenomination(), 5);
		
	}
}
