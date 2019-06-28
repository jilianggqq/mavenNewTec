package edu.gqq.design.listener;

public interface Oberverable {
	void addObserver(Observer o);

	void deleteObserver(Observer o);

	void clear();
}