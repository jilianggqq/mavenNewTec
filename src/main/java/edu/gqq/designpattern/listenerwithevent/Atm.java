package edu.gqq.designpattern.listenerwithevent;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;
public class Atm {
	private List<WithdrawListener> lstListeners = new ArrayList<WithdrawListener>();

	public void addListeners(WithdrawListener listener) {
		lstListeners.add(listener);
	}

	public void withDraw(String name, int num) {
		out.format("%s withdraw $%d money form atm.\n", name, num);
		if (num >= 50) {
			WithdrawEvent we = new WithdrawEvent(this, name, num);
			lstListeners.forEach(x -> x.update(we));
		}
	}
}
