package edu.gqq.design.listener;

import java.util.ArrayList;
import java.util.List;
import static java.lang.System.out;

public class Cat implements Oberverable {

	List<Observer> lstObservers = new ArrayList<Observer>();

	@Override
	public void addObserver(Observer o) {
		lstObservers.add(o);
	}

	@Override
	public void deleteObserver(Observer o) {
		lstObservers.remove(o);
	}

	@Override
	public void clear() {
		lstObservers.clear();
	}

	private void doNotify() {
		out.println("observers reacting...");
		lstObservers.forEach(x -> x.update());
	}

	public void cry() {
		out.println("miao miao...");
		doNotify();
	}
}
