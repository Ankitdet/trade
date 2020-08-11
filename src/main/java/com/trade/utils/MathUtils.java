/**
 * 
 */
package com.trade.utils;

import java.text.DecimalFormat;

/**
 * The Class MathUtils.
 *
 * @author ankit
 */
public class MathUtils {
	
	/**
	 * Round double.
	 *
	 * @param value the value
	 * @param format the format
	 * @return the double
	 */
	public static double roundDouble(double value, String format) {
		DecimalFormat df = new DecimalFormat(format);
		return Double.valueOf(df.format(value));
	}

}
