package edu.gqq.java8.lambda;

import java.util.function.Predicate;
/**
 * understand predict deeply.
 * @author gqq
 *
 */
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class UnderStandPredicate {

	@Test
	public void predicateTest() {
		Predicate<String> ca = (x) -> x.contains("a");
		Predicate<String> cb = (x) -> x.contains("b");
		assertTrue(ca.and(cb).test("abc"));
		assertFalse(ca.and(cb).test("ac"));
		assertTrue(ca.or(cb).test("ac"));
		// this is the wrong test case.
		// assertTrue(ca.or(cb).test("cd"));
	}
}
