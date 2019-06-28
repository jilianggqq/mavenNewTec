package edu.gqq.reflect.two;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Optional;

import org.apache.commons.lang3.mutable.MutableBoolean;

import edu.gqq.reflect.CopyOfPerson;
import edu.gqq.reflect.Person;
import static java.lang.System.out;

public class CopyClassTest {
	public static boolean doCopy(Object obj1, Object obj2) {
		Class<?> c1 = obj1.getClass();
		Class<?> c2 = obj2.getClass();
		MutableBoolean flag = new MutableBoolean(true);
		Arrays.stream(c1.getDeclaredFields()).forEach(x -> {
			x.setAccessible(true);
			Field field;
			// out.println(x.getName() + " " + x.getType());
				Optional<Field> of = Arrays
						.stream(c2.getDeclaredFields())
						.filter(y -> {
							boolean res = y.getName().equals(x.getName())
									&& y.getType().equals(x.getType());
							return res;
						}).findFirst();
				if (of.isPresent()) {
					field = of.get();
					field.setAccessible(true);
					// out.println("field name is " + field.getName());
					try {
						if (field.getType().equals(int.class)) {
							field.setInt(obj2, x.getInt(obj1));
						} else if (field.getType().equals(String.class)) {
							field.set(obj2, x.get(obj1));
						} else {
							field.set(obj2, x.get(obj1));
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						flag.setFalse();
						e.printStackTrace();
					}
					field.setAccessible(false);
				} else {
					out.println(x.getName() + " is not copied.");
					flag.setFalse();
				}
				// out.println(x.getType().equals(int.class));
				// out.println(x.getType().equals(String.class));
				x.setAccessible(false);
			});

		// Arrays.stream(c2.getDeclaredFields())
		// .filter(y -> {
		// boolean res = y.getName().equals("aa")
		// && y.getType().equals(String.class);
		// return res;
		// }).findFirst();
		return flag.getValue();
	}

	public static void main(String[] args) {
		// doCopy(Person.class, Person.class);
		Person p1 = new Person(1, "zhangsan", "zhangsan@qq.com");
		p1.setAddress();
		p1.count = 5;
		CopyOfPerson p2 = new CopyOfPerson();
		doCopy(p1, p2);
		out.println();
		out.println("===============this is result====================");
		out.println(p2);
		out.println(p2.count);
		out.println(p2.getEmail());
		// out.println(p2.getAddress().addr);
	}
}
