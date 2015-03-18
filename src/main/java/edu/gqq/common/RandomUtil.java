package edu.gqq.common;

import java.util.Random;

public class RandomUtil {
	/**
	 * Returns a pseudo-random number between min and max, inclusive. The
	 * difference between min and max can be at most
	 * <code>Integer.MAX_VALUE - 1</code>.
	 *
	 * @param min
	 *            Minimum value
	 * @param max
	 *            Maximum value. Must be greater than min.
	 * @return Integer between min and max, inclusive.
	 * @see java.util.Random#nextInt(int)
	 */
	public static int randInt(int min, int max) {

		// NOTE: Usually this should be a field rather than a method
		// variable so that it is not re-seeded every call.
		Random rand = new Random();

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}

	/**
	 * Returns a pseudo-random number between min and max, inclusive. The
	 * difference between min and max can be at most
	 * <code>Integer.MAX_VALUE - 1</code>.
	 *
	 * @param min
	 *            Minimum value
	 * @param max
	 *            Maximum value. Must be greater than min.
	 * @return Integer between min and max, inclusive.
	 * @see java.util.Random#nextInt(int)
	 */
	// public static double randDouble(double min, double max) {
	//
	// // NOTE: Usually this should be a field rather than a method
	// // variable so that it is not re-seeded every call.
	// Random rand = new Random();
	//
	// // nextInt is normally exclusive of the top value,
	// // so add 1 to make it inclusive
	// double randomNum = rand.nextDouble() * (max - min) + min;
	//
	// return ItuMathUtil.round(randomNum, 2);
	// }
}
