package edu.gqq.basic;

import edu.gqq.common.G;
import edu.gqq.common.GqqBase;

class Class1 {
	public void test() {
		GqqBase.println("this is Class1");
	}
}

interface Interface1 {
	void run();
}

/**
 * 对Java匿名类、匿名接口的测试，可以极大地减少代码量
 * 
 * @author gqq
 *
 */
public class AnonymousTest {
	public static void main(String[] args) {
		// 匿名的Class1
		new Class1(){
			@Override
			public void test() {
//				super.test();
				G.println("this is Anonymous class");
			}
		}.test();

		new Interface1() {

			@Override
			public void run() {
				G.println("this is Anonymous Interface");
			}
		}.run();
	}
}
