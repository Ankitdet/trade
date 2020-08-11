package com.trade.service;

import com.trade.constants.TradeConstants;

/**
 * The Class TradeExecutorStarter.
 * @author ankit
 */

public class TradeExecutorStarter {

	public static void start() {
		Thread t = new Thread(new Runnable() {
			public void run() {
				new TradeExecutorService("/trade.txt", 2, TradeConstants.SYMBOL).run();
			}
		});
		t.start();
	}
}
