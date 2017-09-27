package edu.gqq.design.vending;

public class SoldOutException extends Exception {
	public SoldOutException(String msg) {
		super(msg);
	}
}
