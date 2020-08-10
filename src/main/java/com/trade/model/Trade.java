/**
 * 
 */
package com.trade.model;

import java.math.BigInteger;

/**
 * The Class Trade.
 *
 * @author ankit
 */
public class Trade {
	
	private String sym;
	private BigInteger TS2;
	private double P;
	private double Q;
	
	public Trade(String stock, BigInteger time, double price, double size) throws Exception {
		super();
		this.sym = stock;
		this.P = price;
		this.TS2 = time;
		this.Q = size;
	}

	public String getSym() {
		return sym;
	}

	public void setSym(String sym) {
		this.sym = sym;
	}

	public BigInteger getTS2() {
		return TS2;
	}

	public void setTS2(BigInteger tS2) {
		TS2 = tS2;
	}

	public double getP() {
		return P;
	}

	public void setP(double p) {
		P = p;
	}

	public double getQ() {
		return Q;
	}

	public void setQ(double q) {
		Q = q;
	}

	
	
	
}
