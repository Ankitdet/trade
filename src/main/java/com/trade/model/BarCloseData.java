package com.trade.model;

import com.google.gson.Gson;
import com.trade.constants.Constants;
import com.trade.exception.TradeException;
import com.trade.service.TradeExecutorStarter;
import com.trade.utils.FileUtils;

public class BarCloseData {

	public String event = Constants.OHLC_NOTIFY;
	private String symbol;
	private long bar_number;

	public BarCloseData(long barNumber) throws TradeException {
		this.symbol = TradeExecutorStarter.symbol;
		this.bar_number = barNumber;
		System.out.println(new Gson().toJson(this));
		FileUtils.writeDataIntoFile(new Gson().toJson(this));
	}

	@Override
	public String toString() {
		return "TradeCloseData [event=" + event + ", symbol=" + symbol + ", bar_number=" + bar_number + "]";
	}

}
