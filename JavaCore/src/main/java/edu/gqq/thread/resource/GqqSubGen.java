package edu.gqq.thread.resource;

public class GqqSubGen {

	private int x = 0;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	private int y = 1;

	public void add() {
		x++;
		Thread.yield();
		y++;
	}

	public static void main(String[] args) {
		GqqSubChecker.test(new GqqSubGen());
	}
}
