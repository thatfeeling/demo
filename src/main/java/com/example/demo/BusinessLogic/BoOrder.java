package com.example.demo.BusinessLogic;

import com.example.demo.sharedInterfaces.Order;

public class BoOrder implements Order {

	private int userId;
	private String currencyToSell;
	private String currencyToBuy;
	private double amount;
	private int id;
	
	
	public BoOrder() {
		
	}
	
	public BoOrder(int userId, String currencyToSell, String currencyToBuy, double amount) {
		super();
		this.userId = userId;
		this.currencyToSell = currencyToSell;
		this.currencyToBuy = currencyToBuy;
		this.amount = amount;
	}

	public void setUserId(int id) {
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
	@Override
	public String toString() {
		return "BoOrder [id= " + id + ", userId=" + userId + ", currencyToSell=" + currencyToSell + ", currencyToBuy=" + currencyToBuy
				+ ", amount=" + amount + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
