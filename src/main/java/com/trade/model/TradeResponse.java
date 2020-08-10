package com.trade.model;
/**
 * The Class TradeResponse.
 *
 * @author ankit
 */
public class TradeResponse {

	public double o;
	public double h;
	public double l;
	public double c;
	public double volume;
	public String event = "ohlc_notify";
	public String symbol;
	public long bar_num;

	public double getO() {
		return o;
	}

	public void setO(double o) {
		this.o = o;
	}

	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
	}

	public double getL() {
		return l;
	}

	public void setL(double l) {
		this.l = l;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
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

	public long getBar_num() {
		return bar_num;
	}

	public void setBar_num(long bar_num) {
		this.bar_num = bar_num;
	}

	@Override
	public String toString() {
		return "TradeResponse [o=" + o + ", h=" + h + ", l=" + l + ", c=" + c + ", volume=" + volume + ", event="
				+ event + ", symbol=" + symbol + ", bar_num=" + bar_num + "]";
	}

}
