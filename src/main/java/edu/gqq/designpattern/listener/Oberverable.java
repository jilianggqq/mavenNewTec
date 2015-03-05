package edu.gqq.designpattern.listener;

public interface Oberverable {
	void addObserver(Observer o);

	void deleteObserver(Observer o);

	void clear();
}