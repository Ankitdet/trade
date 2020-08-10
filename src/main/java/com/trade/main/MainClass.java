package com.trade.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.google.gson.Gson;
import com.trade.model.Subscription;
import com.trade.service.TradeStarter;
import com.trade.utils.TimeUtils;

/**
 * The Class MainClass.
 * @author ankit
 */

public class MainClass {

	public static void main(String[] args) {
		try {

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Add your request in JSON:");
			String name = reader.readLine();
			//convert String to Json Object
			Gson gson = new Gson();
			Subscription eventSubscription = gson.fromJson(name, Subscription.class);
			// Set Symbol
			TradeStarter.symbol = eventSubscription.getSymbol();
			// setInterval
			TimeUtils.INTERVAL = eventSubscription.getInterval();
			//Start Trading once get requested.
			TradeStarter.start();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (java.lang.IllegalStateException e) {
			System.out.println("Unable to parse json from String.");
		}

	}
}

// Request : {"event": "subscribe", "symbol": "EOSXBT", "interval": 15}