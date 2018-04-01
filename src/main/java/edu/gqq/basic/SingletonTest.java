package edu.gqq.basic;

import static org.junit.Assert.*;

import org.junit.Test;

public class SingletonTest {

	@Test
	public void testSingleton() throws Exception {
		Singleton1 s11 = Singleton1.getInstance();
		Singleton1 s12 = Singleton1.getInstance();
		assertTrue(s11 == s12);
		Singleton2 s21 = Singleton2.getInstance();
		Singleton2 s22 = Singleton2.getInstance();
		assertTrue(s21 == s22);
	}

}

// In the above code, getInstance() method is not thread safe. Multiple threads can access it at the same time and for
// the first few threads
// when the instance variable is not initialized, multiple threads can enters the if loop and create multiple instances
// and break our singleton implementation.
class Singleton1 {
	private static Singleton1 instance;

	private Singleton1() {

	}

	public static Singleton1 getInstance() {
		if (instance == null) {
			System.out.println("create a new instance");
			instance = new Singleton1();
		}
		return instance;
	}
}

// Create the instance variable at the time of class loading.
// Pros:
//
// Thread safety without synchronization
// Easy to implement
// Cons:
//
// Early creation of resource that might not be used in the application.
// The client application can’t pass any argument, so we can’t reuse it. For example, having a generic singleton class
// for database connection where client application supplies database server properties.
class Singleton2 {
	private static final Singleton2 _instance = new Singleton2();

	private Singleton2() {
	}

	public static Singleton2 getInstance() {
		return _instance;
	}
}

/**
 * best way, double check locking of Singleton.
 *
 *
 * 3rd version : An implementation of double checked locking of Singleton. Intention is to minimize cost of
 * synchronization and improve performance,
 * 
 * by only locking critical section of code, the code which creates instance of Singleton class. *
 * 
 * By the way this is still broken, if we don't make _instance volatile, as another thread can see a half initialized
 * instance of Singleton.
 */

class Singleton3 {
	private static volatile Singleton3 _instance;

	private Singleton3() {
	}

	public static Singleton3 getInstance() {
		if (_instance == null) {
			synchronized (Singleton3.class) {
				if (_instance == null) {
					_instance = new Singleton3();
				}
			}
		}
		return _instance;
	}
}
