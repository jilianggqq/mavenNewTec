package edu.gqq.basic;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

import org.junit.Test;

public class ArrayListVectorLinkedList {
	@Test
	public void testDuration() throws Exception {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		 
		// ArrayList add
		long startTime = System.nanoTime();
		 
		for (int i = 0; i < 100000; i++) {
			arrayList.add(i);
		}
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		System.out.println("ArrayList add:  " + duration);
		 
		// LinkedList add
		startTime = System.nanoTime();
		 
		for (int i = 0; i < 100000; i++) {
			linkedList.add(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("LinkedList add: " + duration);
		 
		// ArrayList get
		startTime = System.nanoTime();
		 
		for (int i = 0; i < 10000; i++) {
			arrayList.get(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("ArrayList get:  " + duration);
		 
		// LinkedList get
		startTime = System.nanoTime();
		 
		for (int i = 0; i < 10000; i++) {
			linkedList.get(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("LinkedList get: " + duration);
		 
		 
		 
		// ArrayList remove
		startTime = System.nanoTime();
		 
		for (int i = 9999; i >=0; i--) {
			arrayList.remove(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("ArrayList remove:  " + duration);
		 
		 
		 
		// LinkedList remove
		startTime = System.nanoTime();
		 
		for (int i = 9999; i >=0; i--) {
			linkedList.remove(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("LinkedList remove: " + duration);
	}
	public static void main(String[] args) {
		// creating an ArrayList
        ArrayList<String> al = new ArrayList<String>();
 
        // adding object to arraylist
        al.add("Practice.GeeksforGeeks.org");
        al.add("quiz.GeeksforGeeks.org");
        al.add("code.GeeksforGeeks.org");
        al.add("contribute.GeeksforGeeks.org");
 
        // traversing elements using Iterator'
        System.out.println("ArrayList elements are:");
        Iterator<String> iterator = al.iterator();
        while (iterator.hasNext()) {
        	System.out.println(iterator.next());
		}
        
     // creating Vector
        Vector<String> v = new Vector<String>();
        v.addElement("Practice");
        v.addElement("quiz");
        v.addElement("code");
 
        // traversing elements using Enumeration
        System.out.println("\nVector elements are:");
        Enumeration<String> e = v.elements();
        while (e.hasMoreElements()) {
        	System.out.println(e.nextElement());
		}
	}
}
