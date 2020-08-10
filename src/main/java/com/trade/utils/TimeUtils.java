/**
 * 
 */
package com.trade.utils;

import java.math.BigInteger;
import java.util.Date;

/**
 * The Class TimeUtils.
 *
 * @author ankit
 */
public class TimeUtils {

	// Check for 15 second interval.
	public static long INTERVAL = 15 ;
	
	public static boolean getTimeDiff(BigInteger date1, BigInteger date2) throws Exception {

		Date date_01 = new Date(date1.longValue());
		Date date_02 = new Date(date2.longValue());
		long diff = date_01.getTime() - date_02.getTime();
		long diffSeconds = diff / 1000 % 60;
		if (diffSeconds == INTERVAL) {
			return true;
		}
		return false;
	}

}
