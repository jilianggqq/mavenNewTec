package edu.gqq.cycle;

import java.io.Serializable;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

//import edu.gqq.java8.lambda.Person;

class Person implements Serializable {
	static final long serialVersionUID = 1L;
	String name; // 姓名
	Person friend; // 朋友

	public Person() {
	}

	public Person(String name) {
		super();
		this.name = name;
	}
}

public class ReferenceQueueTest {
	public static void main(String[] args) {
		// 创建一个对象
		Person person = new Person("sunny");
		// 创建一个引用队列
		ReferenceQueue<Person> rq = new ReferenceQueue<Person>();

		// 创建一个虚引用，让此虚引用引用到person对象
		PhantomReference<Person> pr = new PhantomReference<Person>(person, rq);
		// 切断person引用变量和对象的引用
		person = null;
		// 试图取出虚引用所引用的对象
		// 发现程序并不能通过虚引用访问被引用对象，所以此处输出为null
		System.out.println(pr.get());
		// 强制垃圾回收
		System.gc();
		System.runFinalization();
		// 因为一旦虚引用中的对象被回收后，该虚引用就会进入引用队列中
		// 所以用队列中最先进入队列中引用与pr进行比较，输出true
		System.out.println(rq.poll() == pr);
	}
}
