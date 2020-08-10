package com.trade.calculator;

import com.trade.constants.Constants;
import com.trade.exception.TradeException;
import com.trade.model.BarChartData;
import com.trade.model.BarCloseData;
import com.trade.model.Trade;
import com.trade.utils.MathUtils;
import com.trade.utils.TimeUtils;

/**
 * The Class TradeCalculators
 * 
 * @author ankit
 */

public class TradeCalculators {

	private Trade intervalFirstPrint = null;
	private double open = 0.0;
	private double close = 0.0;
	private double low = 0.0;
	private double high = 0.0;
	private double volume = 0;
	private long barNumber = 1;
	BarChartData responseData = null;

	/**
	 * Aggregate the (open, high, low, close, volume) based on the predefined time
	 * interval (15 seconds)
	 *
	 * @param trade
	 * @throws TradeException
	 */
	public void onTrade(Trade trade) throws TradeException {
		double price = trade.getP();
		if (intervalFirstPrint != null) {
			try {
				if (TimeUtils.getTimeDiff(trade.getTS2(), intervalFirstPrint.getTS2())) {

					// Set the period close price and get aggregate volume
					setVolume(trade);
					new BarChartData(open, high, low, Constants.CLOSE_ZERO, volume, this.barNumber);
					// Reset the intervalFirstPrint to null
					intervalFirstPrint = null;

					// Set close price for next interval.
					close = MathUtils.roundDouble(price, MathUtils.TWO_DEC_DOUBLE_FORMAT);

					this.setBarChartData(price, trade, volume);

					// No trade is placed in that interval.
					new BarCloseData(++this.barNumber);

					// Then a new bar starts at the 15 second interval
					new BarCloseData(++this.barNumber);

				} else {
					setVolume(trade);
					setBarChartData(price, trade, volume);
				}
			} catch (Exception e) {
				throw new TradeException("Error occurred : Unable to proceed on trading data. ");
			}

		} else {
			// System.out.println("Inside else..");
			// Set intervalFirstPrint
			intervalFirstPrint = trade;
			// the first trade price in the day (day open price)
			open = MathUtils.roundDouble(price, MathUtils.TWO_DEC_DOUBLE_FORMAT);
			// the interval low
			low = MathUtils.roundDouble(price, MathUtils.TWO_DEC_DOUBLE_FORMAT);
			// the interval high
			high = MathUtils.roundDouble(price, MathUtils.TWO_DEC_DOUBLE_FORMAT);
			// set the initial volume
			volume = trade.getQ();
			// set close to Zero
			close = Constants.CLOSE_ZERO;
			new BarChartData(open, high, low, close, volume, this.barNumber);

		}
	}

	private void setBarChartData(double price, Trade trade, double volume) throws TradeException {

		if (MathUtils.roundDouble(price, MathUtils.TWO_DEC_DOUBLE_FORMAT) < low)
			low = MathUtils.roundDouble(price, MathUtils.TWO_DEC_DOUBLE_FORMAT);
		// Set the current high price
		if (MathUtils.roundDouble(price, MathUtils.TWO_DEC_DOUBLE_FORMAT) > high)
			high = MathUtils.roundDouble(price, MathUtils.TWO_DEC_DOUBLE_FORMAT);

		new BarChartData(open, high, low, close, volume, this.barNumber);
	}

	private void setVolume(Trade trade) {
		volume += trade.getQ();
	}
}
