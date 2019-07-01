package edu.gqq.design.listenerwithevent;

import java.util.EventObject;

public class WithdrawEvent extends EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WithdrawEvent(Object object, String name, int num) {
		super(object);
		setName(name);
		setNum(num);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private int num;
	private String name;
}
