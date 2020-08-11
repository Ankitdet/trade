package com.trade.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.gson.Gson;
import com.trade.calculator.OHLCDataCalculator;
import com.trade.model.Trade;

/**
 * The Class TradeExecutorService.
 * 
 * @author ankit
 */
public class TradeExecutorService {

	private OHLCDataCalculator tradeCalculators;
	private String tradeFile;
	private int simulationTime;
	private ExecutorService executorService;
	private String symbol;

	public TradeExecutorService(String stockTradesFile, int simulationTime, String sym) {
		super();
		tradeCalculators = new OHLCDataCalculator();
		this.executorService = Executors.newCachedThreadPool();
		this.tradeFile = stockTradesFile;
		this.simulationTime = simulationTime;
		this.symbol = sym;
	}

	public void run() {
		executorService.execute(() -> read());
	}

	private void read() {
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(this.getClass().getResourceAsStream(tradeFile)))) {
			while (true) {
				Thread.sleep(simulationTime);
				String line = br.readLine();
				if (line != null) {
					// Parse line and convert it to trade
					Gson gson = new Gson();
					Trade trade = gson.fromJson(line, Trade.class);
					if (trade.getSym().equals(symbol)) {
						Trade t = new Trade(trade.getSym(), trade.getTS2(), trade.getP(), trade.getQ());
						tradeCalculators.onTrade(t);
					}

				} else {
					executorService.shutdown();
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
