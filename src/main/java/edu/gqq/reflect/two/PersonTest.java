package edu.gqq.reflect.two;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import edu.gqq.reflect.Person;
import edu.gqq.util.Log4jUtil;

public class PersonTest {
	static Logger logger = Log4jUtil.getLogger(PersonTest.class);

	public static void main(String[] args) {
		//

		Class<? extends String> class1 = "foo".getClass();
		logger.debug(class1.getName());
		// logger.debug( System.console().getClass().getName());
		// 2. get class
		Set<String> s = new HashSet<String>();
		Class c = s.getClass();
		logger.debug(c.getName());

		// 3..class
		boolean b;
		// b.getClass();
		logger.debug(boolean.class.getName());
		logger.debug(Person.class.getName());

		// 4.class.forname
		try {
			logger.debug(Class.forName("edu.gqq.reflect.Person2").getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// primitive type
		logger.debug(Void.TYPE.getName());

		// 5. get classes 取得内部类(public)
		Class<?>[] cs = Character.class.getClasses();
		for (Class<?> class2 : cs) {
			logger.debug(class2.getName());
		}

		Class<?>[] cs2 = Person.class.getClasses();
		for (Class<?> class2 : cs2) {
			logger.debug(class2.getName());
		}

		Person person = new Person();
		person.setEmail("qq@qq.com");
		person.setIA(() -> {
			logger.debug(person.getEmail());
		});
		person.doAciont();

		// 6.all classes(including private)
		Class<?>[] cs3 = Character.class.getDeclaredClasses();
		for (Class<?> class2 : cs3) {
			logger.debug(class2.getName());
		}

		// 7.get class from field.
		Field f;
		try {
			f = System.class.getField("out");
			Class cs4 = f.getDeclaringClass();
			logger.debug(cs4.getName());

			// person
			Field emailfield = Person.class.getField("email");
			// name is private ,so throw java.lang.NoSuchFieldException
//			Field namefield = Person.class.getField("name");
			logger.debug(emailfield.getDeclaringClass().getName());
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	public class MyClass {
//	    static Object o = new Object() {
//	        public void m() {} 
//	    };
//	    
//	}
}
