package edu.gqq.java8.lambda;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class TestLambda1 {

	/**
	 * 没有参数、没有返回值的接口
	 * 
	 * @author gqq
	 *
	 */
	interface Action {
		void doAction();
	}

	interface LengthInt {
		long getLen(String str);
	}

	public void doSomeActions(Action action, String name) {
		action.doAction();
		System.out.println(name);
	}

	public long getDoubleLength(LengthInt li, String str) {
		return li.getLen(str) * 2;
	}

	public boolean isTrue(Predicate<String> ps, String str) {
		return ps.test(str);
	}

	public int addString(Function<String, Integer> func, String str, int a) {
		return a + func.apply(str);
	}

	public static <K, V> void processPersonsWithFunction(Iterable<K> group,
			Predicate<K> pre, Function<K, V> func, Consumer<V> consu) {
		for (K element : group) {
			if (pre.test(element)) {
				V info = func.apply(element);
				consu.accept(info);
			}
		}
	}

	public static void main(String[] args) {
		new TestLambda1()
				.doSomeActions(() -> System.out.print("Hello "), "gqq");
		long len = new TestLambda1().getDoubleLength(new LengthInt() {

			@Override
			public long getLen(String str) {
				return str.length();
			}
		}, "Hello");
		System.out.println(len);

		len = new TestLambda1().getDoubleLength((String str) -> str.length(),
				"HelloWorld");
		System.out.println(len);

		boolean res = new TestLambda1().isTrue((new Predicate<String>() {

			@Override
			public boolean test(String t) {
				return t.contains("s");
			}
		}).and(new Predicate<String>() {

			@Override
			public boolean test(String t) {
				return t.contains("h");
			}
		}), "shell");

		System.out.println(res);

		int res2 = new TestLambda1().addString((s) -> Integer.parseInt(s),
				"33", 5);
		System.out.println(res2);

		// Aggregate Operations
		List<String> myList = Arrays.asList("zhangsan", "lisi", "wangwu",
				"liuliu");
		myList.stream().filter(x -> x.contains("a")).map(x -> x.toUpperCase())
				.forEach(x -> System.out.println(x));

	}
}
