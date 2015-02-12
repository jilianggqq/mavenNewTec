package edu.gqq.fortest;

import java.text.DecimalFormat;

public class ChartTest {

	/**
	 * rounds the given number to the next significant number
	 * 
	 * @param number
	 * @return
	 */
	public static float roundToNextSignificant(double number) {
		final float d = (float) Math.ceil((float) Math.log10(number < 0 ? -number : number));
		final int pw = 1 - (int) d;
		final float magnitude = (float) Math.pow(10, pw);
		final long shifted = Math.round(number * magnitude);
		return shifted / magnitude;
	}

	/**
	 * Returns the appropriate number of decimals to be used for the provided
	 * number.
	 * 
	 * @param number
	 * @return
	 */
	public static int getDecimals(float number) {

		float i = roundToNextSignificant(number);
		return (int) Math.ceil(-Math.log10(i)) + 2;
	}

	/**
	 * calculates the required number of digits for the values that might be
	 * drawn in the chart (if enabled) <br>
	 * 如何格式化一个float类型的数组，这个是很有用的哦。
	 */
	protected static String calcFormats(float value) {

		float reference = 0f;

		int digits = getDecimals(reference);

		StringBuffer b = new StringBuffer();
		for (int i = 0; i < digits; i++) {
			if (i == 0)
				b.append(".");
			b.append("0");
		}

		System.out.println(b.toString());
		DecimalFormat formatter = new DecimalFormat("###,###,###,##0" + b.toString());
		// mValueFormatter = new DefaultValueFormatter(formatter);
		return formatter.format(value);
	}
}
