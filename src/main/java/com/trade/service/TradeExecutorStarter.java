package com.trade.service;

/**
 * The Class TradeExecutorStarter.
 * @author ankit
 */

public class TradeExecutorStarter {

	public static String symbol;
	public static int interval;

	public static void start() {
		Thread t = new Thread(new Runnable() {
			public void run() {
				new TradeExecutorService("/trade.txt", 2, symbol).run();
			}
		});
		t.start();
	}
}
