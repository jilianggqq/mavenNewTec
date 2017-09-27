package edu.gqq.design.vending;

import java.util.HashMap;
import java.util.Map;

public class Inventory<T> {
	private Map<T, Integer> storage;
	public Inventory() {
		storage = new HashMap<>();
	}
	
	/**
	 * insert one item into inventory
	 * @param t
	 */
	public void insertItem(T t, int number) {
		if (storage.containsKey(t)) {
			storage.put(t, storage.get(t) + number);
		} else {
			storage.put(t, number);
		}
	}
	
	/**
	 * delete item from inventory
	 * @param t
	 */
	public void deleteItem(T t) {
		if (storage.containsKey(t)) {
			storage.put(t, storage.get(t) - 1);
			if (storage.get(t) == 0) {
				storage.remove(t);
			}
		}
	}
	
	public boolean hasItem(T t) {
		return storage.containsKey(t);
	}
	
	/**
	 * get the count of one item.
	 * @param t
	 * @return
	 */
	public int getItemCount(T t) {
		if (!storage.containsKey(t)) return 0;
		return storage.get(t);
	}
}
