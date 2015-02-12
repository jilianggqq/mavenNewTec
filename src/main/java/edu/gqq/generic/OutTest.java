package edu.gqq.generic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 测试泛型
 * 
 * @author gqq
 *
 */
public class OutTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPut() {
		new BaseList(new Out<Base>(new Derive1()), new Out<Base>(new Derive2())).print();
	}

}
