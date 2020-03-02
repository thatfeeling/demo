package com.example.demo.BusinessLogic;

import com.example.demo.sharedInterfaces.Order;

public class BoOrder implements Order {

	private int userId;
	private String currencyToSell;
	private String currencyToBuy;
	private double amount;
	
	
	public void setOrderId(int id) {
		this.userId = id;
	}
	
	public void setCurrencyToSell(String currency) {
		this.currencyToSell = currency;
	}
	
	public void setCurrencyToBuy(String currency) {
		this.currencyToBuy = currency;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Override
	public int getUserId() {
		return this.userId;
	}

	@Override
	public String getCurrencyToSell() {
		return this.currencyToSell;
	}
	
	@Override
	public String getCurrencyToBuy() {
		return this.currencyToBuy;
	}

	@Override
	public double getAmount() {
		return this.amount;
	}

}
