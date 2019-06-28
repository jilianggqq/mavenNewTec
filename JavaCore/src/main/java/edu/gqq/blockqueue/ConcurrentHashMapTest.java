package edu.gqq.blockqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * from https://www.geeksforgeeks.org/difference-hashmap-concurrenthashmap/
 * @author gqq
 *
 */
public class ConcurrentHashMapTest implements Runnable {
	static HashMap<Integer, String> hashMap = new HashMap<>();
	static ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();

	public static void main(String[] args) {
		
		// 1. test normal hashMap, ConcurrentModificationException
//		hashMap.put(1, "aaa");
//		hashMap.put(2, "bbb");
//		hashMap.put(3, "ccc");
//
//		Thread t1 = new Thread(new ConcurrentHashMapTest());
//		t1.start();
//
//		// Exception in thread "main" java.util.ConcurrentModificationException
//		for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println(entry.getKey() + " --> " + entry.getValue());
//		}
		
		// 2. test concurrentHashMap
		concurrentHashMap.put(1, "aaa");
		concurrentHashMap.put(2, "bbb");
		concurrentHashMap.put(3, "ccc");

		Thread t2 = new Thread(new Concurrent());
		t2.start();

		// no ConcurrentModificationException here.
		for (Map.Entry<Integer, String> entry : concurrentHashMap.entrySet()) {
			System.out.println(entry.getKey() + " --> " + entry.getValue());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("size after remove:" + concurrentHashMap.size());
		
	}

	@Override
	public void run() {
		hashMap.put(4, "ddd");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Concurrent implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// ConcurrentHashMapTest.concurrentHashMap.put(4, "ddd");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ConcurrentHashMapTest.concurrentHashMap.remove(1);
	}
	
}
