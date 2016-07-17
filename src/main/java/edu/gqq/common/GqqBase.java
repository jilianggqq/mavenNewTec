package edu.gqq.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GqqBase {

	static public <T> void println(T t) {
		System.out.println(t);
	}

	static public <T> void print(T t) {
		System.out.print(t);
	}

	public static void println() {
		System.out.println();
	}

	public static String getDay() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy年M月");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.MONTH, -1);

		// cal.add(Calendar.DATE, index);
		return dateFormat.format(cal.getTime());
	}
}
