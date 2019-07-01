package edu.gqq.generic;

public class Out<T extends Base> {
	T base;

	public Out(T t) {
		base = t;
	}

	public void put() {
		System.out.println(base.getinfo());
	}
}
