package com.trade.calculator;

import com.google.gson.Gson;
import com.trade.model.Trade;
import com.trade.model.TradeResponse;
import com.trade.service.TradeStarter;
import com.trade.utils.FileUtils;
import com.trade.utils.MathUtils;
import com.trade.utils.TimeUtils;

/**
 * The Class TradeCalculators
 * @author ankit
 */

public class TradeCalculators {

	private Trade intervalFirstPrint = null;
	private double open = 0.0;
	private double close = 0.0;
	private double low = 0.0;
	private double high = 0.0;
	private long volume = 0;
	private long barNumber = 1;
	TradeResponse responseData  = null;

	public void writeData(double o, double h, double l, double c, long v) {
		responseData = new TradeResponse();
		responseData.o = o;
		responseData.h = h;
		responseData.l = l;
		responseData.c = c;
		responseData.volume = v;
		responseData.symbol = TradeStarter.symbol;
		responseData.bar_num = barNumber;
		FileUtils.writeDataIntoFile(new Gson().toJson(responseData));
	}

	// Write data when close interval.
	public void writeData() {
		responseData = new TradeResponse();
		responseData.symbol = TradeStarter.symbol;
		responseData.bar_num = ++barNumber;
		++barNumber;
		FileUtils.writeDataIntoFile(new Gson().toJson(responseData));
	}

	/**
	 * Aggregate the (open, high, low, close, volume) based on the predefined time
	 * interval (15 seconds)
	 *
	 * @param trade the t
	 */
	public void onTrade(Trade trade) {
		double price = trade.getP();
		if (intervalFirstPrint != null) {
			try {
				if (TimeUtils.getTimeDiff(trade.getTS2(), intervalFirstPrint.getTS2())) {
					// Set the period close price
					close = MathUtils.roundDouble(price, MathUtils.TWO_DEC_DOUBLE_FORMAT);
					// Reset the intervalFirstPrint to null
					intervalFirstPrint = null;
					writeData();
				} else {
					// Set the current low price
					if (MathUtils.roundDouble(price, MathUtils.TWO_DEC_DOUBLE_FORMAT) < low)
						low = MathUtils.roundDouble(price, MathUtils.TWO_DEC_DOUBLE_FORMAT);

					// Set the current high price
					if (MathUtils.roundDouble(price, MathUtils.TWO_DEC_DOUBLE_FORMAT) > high)
						high = MathUtils.roundDouble(price, MathUtils.TWO_DEC_DOUBLE_FORMAT);

					volume += trade.getQ();
					writeData(open, high, low, close, volume);
				}
			} catch (Exception e) {
				System.out.println("Unable to proceed on trading data. Error occurred.");
				e.printStackTrace();
			}

		} else {
			// Set intervalFirstPrint
			intervalFirstPrint = trade;
			// the first trade price in the day (day open price)
			open = MathUtils.roundDouble(price, MathUtils.TWO_DEC_DOUBLE_FORMAT);
			// the interval low
			low = MathUtils.roundDouble(price, MathUtils.TWO_DEC_DOUBLE_FORMAT);
			// the interval high
			high = MathUtils.roundDouble(price, MathUtils.TWO_DEC_DOUBLE_FORMAT);
			// set the initial volume
			volume = (long) trade.getQ();
		}
	}

}
