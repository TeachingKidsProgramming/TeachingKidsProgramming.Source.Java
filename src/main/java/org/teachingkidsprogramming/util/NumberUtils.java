package org.teachingkidsprogramming.util;

import com.spun.util.StringUtils;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * A static class of convenience functions for Manipulating numbers
 **/
public class NumberUtils {
	public static Random RANDOM = new Random();

	/**
	 * Loads an int from a String.
	 **/
	public static int load(String i, int defaultValue) {
		return load(i, defaultValue, true);
	}

	/**
	 * Loads an int from a String.
	 **/
	public static int load(String i, int defaultValue, boolean stripNonNumeric) {
		try {
			i = stripNonNumeric ? StringUtils.stripNonNumeric(i, true, true)
					: i;
			defaultValue = Integer.parseInt(i);
		} catch (Exception ignored) {
		}
		return defaultValue;
	}

	public static double load(String i, double defaultValue) {
		try {
			i = StringUtils.stripNonNumeric(i, true, true);
			defaultValue = Double.parseDouble(i);
		} catch (Exception ignored) {
		}
		return defaultValue;
	}

	public static boolean equals(double one, double two, double delta) {
		double actualDelta = one - two;
		return (-delta < actualDelta) && (actualDelta < delta);
	}

	/**
	 * @deprecated use Query.sum()
	 */
	public static double sum(Object[] attribs, String methodName,
			Object[] params) {
		try {
			if (attribs == null || attribs.length == 0) {
				return 0.00;
			}
			Method method = MethodExecutionPath.Parameters.getBestFitMethod(
					attribs[0].getClass(),
					methodName,
					params == null ? null : (Class[]) ObjectUtils.extractArray(
                            params, "getClass"));
			double sum = 0;
            for (Object attrib : attribs) {
                sum += ((Number) method.invoke(attrib, params))
                        .doubleValue();
            }
			return sum;
		} catch (Throwable t) {
			throw ObjectUtils.throwAsError(t);
		}
	}

	/**
	 * randomly chooses a number between the minimum and maximum
	 * <div><b>Example:</b>
	 * {@code int grade =  NumberUtils.getRandomInt(1,100);} </div>
	 * 
	 * @param minimum
	 *            The lowest possible value (inclusive)
	 * @param maximum
	 *            The highest possible value (inclusive)
	 * @return the random number
	 */
	public static int getRandomInt(int minimum, int maximum) {
		int diff = maximum - minimum;
		if (diff == 0) {
			return maximum;
		} else {
			return RANDOM.nextInt(diff) + minimum;
		}
	}
}