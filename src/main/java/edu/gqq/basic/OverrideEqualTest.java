package edu.gqq.basic;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

import org.junit.Test;

//import com.google.common.base.Objects;

public class OverrideEqualTest {

	@Test
	public void testEquals() throws Exception {
		HashSet<Point> set = new HashSet<>();
		set.add(new Point(3, 2));
		set.add(new Point(3, 2));
		assertEquals(2, set.size());
		HashSet<Point> set2 = new HashSet<>();
		set2.add(new NewPoint(3, 2));
		set2.add(new NewPoint(3, 2));
		assertEquals(1, set2.size());

		Map<NewPoint, Integer> counts = new HashMap<>();
		NewPoint[] points = { new NewPoint(3, 4), new NewPoint(4, 5), new NewPoint(8, 9), new NewPoint(4, 5) };
		for (NewPoint newPoint : points) {
			if (counts.containsKey(newPoint)) {
				counts.put(newPoint, counts.get(newPoint) + 1);
			} else {
				counts.put(newPoint, 1);
			}
		}

		for (Map.Entry<NewPoint, Integer> entry : counts.entrySet()) {
			System.out.println("(" + entry.getKey().x + "," + entry.getKey().y + ")" + " " + entry.getValue());
		}

		HashSet<NewPoint2> set3 = new HashSet<>();
		set3.add(new NewPoint2(3, 2));
		set3.add(new NewPoint2(3, 2));
		assertEquals(1, set3.size());
	}
}

class NewPoint2 extends Point {
	public NewPoint2() {
		super();
	}

	public NewPoint2(int x, int y) {
		super(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		NewPoint2 np = (NewPoint2) obj;
		return np.x == this.x && np.y == this.y;
	}

	@Override
	public int hashCode() {
		// return Objects.hash(this,x, this.y);
		return com.google.common.base.Objects.hashCode(this.x, this.y);
		// return x + y;
	}
}

class NewPoint extends Point {
	public NewPoint() {
		super();
	}

	public NewPoint(int x, int y) {
		super(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		NewPoint np = (NewPoint) obj;
		return np.x == this.x && np.y == this.y;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 53 * hash + this.x;
		hash = 53 * hash + this.y;
		return hash;
		// this solution is also ok.
		// return x * 31 + y * 17;
	}
}

// Definition for a point.
class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}
