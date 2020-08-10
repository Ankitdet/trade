package com.trade.ohlc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.google.gson.Gson;
import com.trade.exception.TradeException;
import com.trade.model.EventSubscription;
import com.trade.service.TradeExecutorStarter;
import com.trade.utils.TimeUtils;

/**
 * The Class OHLCServer.
 * 
 * @author ankit
 */

public class OHLCServer {

	public static void main(String[] args) throws TradeException {
		try {

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Add your request in JSON:");
			String name = reader.readLine();
			// convert String to Json Object
			Gson gson = new Gson();
			EventSubscription eventSubscription = gson.fromJson(name, EventSubscription.class);
			// Set Symbol
			TradeExecutorStarter.symbol = eventSubscription.getSymbol();
			// setInterval
			TimeUtils.INTERVAL = eventSubscription.getInterval();
			// Start Trading once get requested.
			TradeExecutorStarter.start();
		} catch (IOException e) {
			throw new TradeException("I/O exception, file not found");
		} catch (java.lang.IllegalStateException e) {
			throw new TradeException("Unable to parse json from String.");
		}

	}
}
