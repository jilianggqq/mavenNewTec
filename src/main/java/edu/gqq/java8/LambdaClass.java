package edu.gqq.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class foo {

	public int id;
	public void parent() {
		System.out.println("parent" + id);
	}

}

class bar extends foo {

	public bar(int i){
		id = i;
	}
	
	public void son() {
		System.out.println("son" + id);
	}

}

public class LambdaClass {

	public static void main(String[] args) {
		System.out.println("=== RunnableTest ===");

		Runnable r = new Runnable() {

			public void run() {
				System.out.println("Hello world one!");
			}
		};

		Runnable r2 = () -> System.out.println("Hello world two!");
		r2.run();

		// java8可以使用的方式:
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		list.forEach(n -> System.out.println(n*2));
		r.run();
		
		// 在调用forEach的时候，T已经是固定的了，就是bar.但是consume的T1是接收T的参数，因此必须是T的父类。
		List<bar> bars = new ArrayList<bar>();
		bars.add(new bar(0));
		bars.add(new bar(1));
		bars.add(new bar(2));
		Consumer<foo> c = (x) -> x.parent();
		bars.forEach(c);

	}
}
