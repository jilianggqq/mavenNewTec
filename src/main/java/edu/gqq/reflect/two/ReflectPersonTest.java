package edu.gqq.reflect.two;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

import static java.lang.System.out;

public class ReflectPersonTest {
	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			NoSuchMethodException, SecurityException, IllegalArgumentException,
			InvocationTargetException {
		Class<?> personClass = Class.forName("edu.gqq.reflect.Person");

		Object person = personClass.newInstance();
		Method method1 = personClass.getDeclaredMethod("setId", int.class);
		Method method2 = personClass.getDeclaredMethod("setName", String.class);
		method1.invoke(person, 3);
		method2.invoke(person, "zhangsan");

		Method method3 = personClass.getDeclaredMethod("getId");
		Method method4 = personClass.getDeclaredMethod("getName");
		// out.println(method3.getReturnType().getName());
		// method3.in
		String string = "";
		string += printInfo(method3, person);
		string += printInfo(method4, person);
		out.print(string);
	}

	private static String printInfo(Method m, Object o)
			throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		String res;
		if (m.getReturnType().isPrimitive()) {
			res = m.invoke(o) + "";
			out.format("res is %s, is primitive\n", res);
		} else if (m.getReturnType().equals(String.class)) {
			res = (String) m.invoke(o);
			out.format("res is %s, is string\n", res);
		} else {
			res = m.invoke(o).toString();
		}
		return res;
	}
}
