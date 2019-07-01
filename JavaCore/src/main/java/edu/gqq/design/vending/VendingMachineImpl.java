package edu.gqq.design.vending;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineImpl implements VendingMachine {

	private Inventory<Coin> cashInventory = new Inventory<>();
	private Inventory<Item> itemInventory = new Inventory<>();

	private int currentBalance;

	public VendingMachineImpl() {
		initialize();
	}

	private void initialize() {
		// coins.insertItem(Coin.Penney, 5);
		// coins.insertItem(Coin.Nickel, 5);
		// coins.insertItem(Coin.Dime, 5);
		// coins.insertItem(Coin.Quarter, 5);
		// items.insertItem(Item.Coke, 5);
		// items.insertItem(Item.Pepsi, 5);
		// items.insertItem(Item.Soda, 5);
		for (Coin coin : Coin.values()) {
			cashInventory.insertItem(coin, 5);
		}

		for (Item item : Item.values()) {
			itemInventory.insertItem(item, 5);
		}
		currentBalance = 0;
	}

	/**
	 * insert coin into vending mechine.
	 */
	@Override
	public void insertCoin(Coin coin) {
		currentBalance += coin.getDenomination();
		cashInventory.insertItem(coin, 1);
	}

	@Override
	public int selectItemAndGetPrice(Item item) throws SoldOutException {
		if (!itemInventory.hasItem(item)) {
			throw new SoldOutException(item.getDesc() + " has been sold out");
		}
		return item.getPrice();
	}

	@Override
	public Bucket<Item, List<Coin>> collectItemAndChange(Item item) throws SoldOutException, NotFullPaidException, NotSufficientChangeException {
		int price = selectItemAndGetPrice(item);
		if (price > currentBalance) {
			throw new NotFullPaidException("you need to pay more, remain is ", price - currentBalance);
		}
		List<Coin> returnCoins = getChange(currentBalance - price);
		currentBalance -= price;
		// delete this item form
		itemInventory.deleteItem(item);
		Bucket<Item, List<Coin>> res = new Bucket<Item, List<Coin>>(item, returnCoins);
		return res;
	}

	@Override
	public List<Coin> refund() throws NotSufficientChangeException {
		return getChange(currentBalance);
	}

	public List<Coin> getChange(int balance) throws NotSufficientChangeException {
		List<Coin> res = new ArrayList<>();
		while (balance > 0) {
			boolean has = false;
			if (balance >= Coin.Quarter.getDenomination()) {
				if (cashInventory.hasItem(Coin.Quarter)) {
					res.add(Coin.Quarter);
					has = true;
					cashInventory.deleteItem(Coin.Quarter);
					balance -= Coin.Quarter.getDenomination();
				} else if (cashInventory.hasItem(Coin.Dime)) {
					res.add(Coin.Dime);
					has = true;
					cashInventory.deleteItem(Coin.Dime);
					balance -= Coin.Dime.getDenomination();
				} else if (cashInventory.hasItem(Coin.Nickel)) {
					res.add(Coin.Nickel);
					has = true;
					cashInventory.deleteItem(Coin.Nickel);
					balance -= Coin.Nickel.getDenomination();
				} else if (cashInventory.hasItem(Coin.Penney)) {
					res.add(Coin.Penney);
					has = true;
					cashInventory.deleteItem(Coin.Penney);
					balance -= Coin.Penney.getDenomination();
				}
			} else if (balance >= Coin.Dime.getDenomination()) {
				if (cashInventory.hasItem(Coin.Dime)) {
					res.add(Coin.Dime);
					has = true;
					cashInventory.deleteItem(Coin.Dime);
					balance -= Coin.Dime.getDenomination();
				} else if (cashInventory.hasItem(Coin.Nickel)) {
					res.add(Coin.Nickel);
					has = true;
					cashInventory.deleteItem(Coin.Nickel);
					balance -= Coin.Nickel.getDenomination();
				} else if (cashInventory.hasItem(Coin.Penney)) {
					res.add(Coin.Penney);
					has = true;
					cashInventory.deleteItem(Coin.Penney);
					balance -= Coin.Penney.getDenomination();
				}
			} else if (balance >= Coin.Nickel.getDenomination()) {
				if (cashInventory.hasItem(Coin.Nickel)) {
					res.add(Coin.Nickel);
					has = true;
					cashInventory.deleteItem(Coin.Nickel);
					balance -= Coin.Nickel.getDenomination();
				} else if (cashInventory.hasItem(Coin.Penney)) {
					res.add(Coin.Penney);
					has = true;
					cashInventory.deleteItem(Coin.Penney);
					balance -= Coin.Penney.getDenomination();
				}
			} else if (balance >= Coin.Penney.getDenomination()) {
				if (cashInventory.hasItem(Coin.Penney)) {
					res.add(Coin.Penney);
					has = true;
					cashInventory.deleteItem(Coin.Penney);
					balance -= Coin.Penney.getDenomination();
				}
			}

			// if did not has enougth change. throw NotSufficientChangeException
			if (!has) {
				for (Coin cn : res) {
					cashInventory.insertItem(cn, 1);
				}
				throw new NotSufficientChangeException("Not sufficient charge");
			}
		}
		return res;
	}

	@Override
	public void reset() {
		initialize();
	}

}
