package edu.gqq.guava;

import com.google.common.base.Optional;
import com.google.common.base.Strings;

import junit.framework.TestCase;
import static java.lang.System.out;

import java.util.List;

public class OptionalTest extends TestCase {
	
	public void testOptional() {
		
		//至于optional，我还是没有找到好的用法。
		Optional<Integer> possible = Optional.of(5);
		assertEquals(true, possible.isPresent());
		assertEquals(Integer.valueOf(5), possible.get());
		
//		List<String> strs = null;
//		Optional<List<String>> attrs = Optional.of(strs);
//		assertEquals(null, attrs);
	}
	
	public void testStrings() {
		boolean nullOrEmpty = Strings.isNullOrEmpty("");
		assertEquals(true, nullOrEmpty);
		
		String string = Strings.nullToEmpty(null);
		assertEquals("", string);
	}
}
