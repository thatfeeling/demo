package com.example.demo.BusinessLogic;

import com.example.demo.sharedInterfaces.Wallet;

public class BoWallet implements Wallet{
	
	private double BTC;
	private double ETH;
	private int id;
	private int userId;
	
	public double getBTC() {
		return BTC;
	}
	public void setBTC(double btc) {
		this.BTC = btc;
	}
	public double getETH() {
		return ETH;
	}
	public void setETH(double eth) {
		this.ETH = eth;
	}
	@Override
	public String toString() {
		return "BoWallet [BTC=" + BTC + ", ETH=" + ETH + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public int getUserId() {
		return this.userId;
	}
	
}
