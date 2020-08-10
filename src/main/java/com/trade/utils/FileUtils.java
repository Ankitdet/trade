package com.trade.utils;

import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {

	public static void writeDataIntoFile(String data) {

		try (FileWriter file = new FileWriter("barChart.json", true)) {
			file.write("\n");
			file.write(data);
		} catch (IOException e) {
			System.out.println("Enable to create file or write into.");
			e.printStackTrace();
		}
	}
}
