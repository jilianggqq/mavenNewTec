package edu.gqq.basic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class MyPoint {

	public static void main(String[] args) {
		Set<MyPoint> list = new HashSet<>();
		MyPoint p1 = new MyPoint(3, 2);
		MyPoint p2 = new MyPoint(3, 2);
		list.add(p1);
		list.add(p2);
		assertEquals(1, list.size());
	}

	// public MyPoint() {
	// // TODO Auto-generated constructor stub
	// }
	public MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	int x, y;

	@Override
	public boolean equals(Object obj) {
		MyPoint mp = (MyPoint) obj;
		return mp.x == this.x && mp.y == this.y;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 53 * hash + this.x;
		hash = 53 * hash + this.y;
		return hash;
	}
}
