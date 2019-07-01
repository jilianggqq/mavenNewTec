package edu.gqq.design.vending;

import java.util.List;

public interface VendingMachine {
	// insert coins into vending machine.
	void insertCoin(Coin coin);
	// select one item, and get its price
	int selectItemAndGetPrice(Item item)  throws SoldOutException ;
	
	Bucket<Item, List<Coin>> collectItemAndChange(Item item) throws SoldOutException, NotFullPaidException, NotSufficientChangeException;
	
	List<Coin> refund() throws NotSufficientChangeException;
	
	void reset();
}
