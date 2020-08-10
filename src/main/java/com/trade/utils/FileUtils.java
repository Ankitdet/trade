package com.trade.utils;

import java.io.FileWriter;
import java.io.IOException;

import com.trade.exception.TradeException;
/**
 * The Class FileUtils.
 *
 * @author ankit
 */
public class FileUtils {

	public static void writeDataIntoFile(String data) throws TradeException {

		try (FileWriter file = new FileWriter("barChart.json", true)) {
			file.write("\n");
			file.write(data);
		} catch (IOException e) {
			throw new TradeException("Error occurred: Unable to write data into file. Please remove file or backup");
		}
	}

}
