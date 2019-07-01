package edu.gqq.basic;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

import org.junit.Test;

public class HashSetTest {
	@Test
	public void testDelete() throws Exception {
		//
		HashSet<NumberClass> set = new HashSet<>();
		// 1, 3, 5, 7, 10, 20, 30, 3
		set.addAll(Arrays.asList(new NumberClass(1), new NumberClass(3), new NumberClass(5), new NumberClass(7), new NumberClass(10),
				new NumberClass(20), new NumberClass(30), new NumberClass(1), new NumberClass(3)));
		set.forEach(x -> System.out.println(x + ", "));
		System.out.println();

		HashSet<NumberClass> newset = new HashSet<>();
		Iterator<NumberClass> iterator = set.iterator();
		while (iterator.hasNext()) {
			NumberClass val = iterator.next();
			newset.add(val);
			iterator.remove();
		}

		System.out.println("----------------------------------------");
		System.out.println(set.size());
		System.out.println(newset.size());
		
		
		HashSet<NumberClass> newset2 = new HashSet<>();
		newset2.addAll(newset);
		newset.clear();
		System.out.println("----------------------------------------");
		System.out.println(newset.size());
		System.out.println(newset2.size());
		
	}
}

class NumberClass {
	int num;

	public NumberClass(int n) {
		this.num = n;
	}

	@Override
	public int hashCode() {
		return 31 * num + 3;
	}

	@Override
	public boolean equals(Object obj) {
		return this.num == ((NumberClass) obj).num;
	}

	@Override
	public String toString() {
		return num + "";
	}
}
