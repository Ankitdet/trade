package com.trade.model;

/**
 * The Class Trade.
 *
 * @author Subscription
 */
public class Subscription {

	private String event;
	private String symbol;
	private int interval;
	private long barNumber;

	public long getBarNumber() {
		return barNumber;
	}

	public void setBarNumber(long barNumber) {
		this.barNumber = barNumber;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	@Override
	public String toString() {
		return "Subscription [event=" + event + ", symbol=" + symbol + ", interval=" + interval + "]";
	}
}
