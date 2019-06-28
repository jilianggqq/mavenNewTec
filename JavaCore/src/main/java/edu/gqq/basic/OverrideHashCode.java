package edu.gqq.basic;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;
import static org.junit.Assert.*;

public class OverrideHashCode {
	String string;

	public OverrideHashCode(String str) {
		string = str;
	}

	@Override
	public int hashCode() {
		if (string.contains("ab")) {
			return 0;
		}
		return string.length();
	}

	@Override
	public boolean equals(Object object) {
		// return super.equals(obj);
		if (object == null) {
			return false;
		}
		if (object == this) {
			return true;
		}
		if (!(object instanceof OverrideHashCode)) {
			return false;
		}
		OverrideHashCode other = (OverrideHashCode) object;
		if (other.hashCode() == this.hashCode()) {
			return true;
		}
		return false;
	}

}

class TestHash {
	@Test
	public void testOverrideHashCode() {
		OverrideHashCode ohc = new OverrideHashCode("s1");
		OverrideHashCode ohc2 = new OverrideHashCode("s2");

		HashSet<OverrideHashCode> set = new HashSet<>();
		set.add(ohc);
		set.add(ohc2);
		assertEquals(1, set.size());
		// System.out.println(set);
		assertEquals(ohc, ohc2);

		OverrideHashCode aa = new OverrideHashCode("cab");
		OverrideHashCode bb = new OverrideHashCode("abc");

		set.clear();
		set.add(aa);
		set.add(bb);
		assertEquals(1, set.size());
	}
}
