package edu.gqq.java8.lambda2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;

import com.google.common.base.Optional;

import edu.gqq.common.G;

import static org.junit.Assert.*;

public class FlatMapLearning {

	@Test
	public void testFooAndBar() {
		List<Foo> fs = new ArrayList<>();
		IntStream.range(1, 4).forEach(i -> fs.add(new Foo("Foo" + i)));
		fs.forEach(f -> IntStream.range(1, 4).forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));

		assertEquals(3, fs.size());
		assertEquals(3, fs.get(0).bars.size());

		// we've successfully transformed the stream of three foo objects into a stream of nine bar objects.
		long cnt = fs.stream().flatMap(f -> f.bars.stream()).count();
		assertEquals(9, cnt);
		fs.stream().flatMap(f -> f.bars.stream()).forEach(x -> G.println(x.name));
	}

	@Test
	public void testFooAndBarSingleLine() {
		G.println("***testFooAndBarSingleLine**");
		IntStream.range(1, 4).mapToObj(i -> new Foo("Foo" + i)).peek(f -> {
			IntStream.range(1, 4).mapToObj(j -> new Bar("Bar" + j + " <- " + f.name)).forEach(b -> f.bars.add(b));
		}).flatMap(f -> {
			return f.bars.stream();
		}).forEach(G::println);

	}
	
//	@Test
//	public void avoidNullPointerExceptionsTest(){
//		Optional.of(new Outer())
//			.flatMap(x->o -> Optional.ofNullable(o.nested)).
//			 flatMap(n -> Optional.ofNullable(n.inner))
//			    .flatMap(i -> Optional.ofNullable(i.foo))
//			    .ifPresent(System.out::println);
//	}
}

class Foo {
	String name;
	List<Bar> bars = new ArrayList<>();

	Foo(String name) {
		this.name = name;
	}
}

class Bar {
	String name;

	public String toString() {
		return this.name;
	};

	Bar(String name) {
		this.name = name;
	}
}

class Outer {
	Nested nested;
}

class Nested {
	Inner inner;
}

class Inner {
	String foo;
}