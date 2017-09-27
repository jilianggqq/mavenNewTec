package edu.gqq.design.vending;

public class Bucket<T, S> {
	private T t;
	private S s;

	public Bucket(T t, S s) {
		this.t = t;
		this.s = s;
	}

	public T getT() {
		return t;
	}

	public S getS() {
		return s;
	}
}
