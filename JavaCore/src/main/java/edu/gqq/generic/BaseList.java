package edu.gqq.generic;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BaseList<T extends Out<? extends Base>> {

	ArrayList<T> ts = new ArrayList<>();

	public BaseList(T t1, T t2) {
		ts.add(t1);
		ts.add(t2);
	}

	public void print() {
		ts.stream().forEach(x -> x.put());
	}

}
