package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.sharedInterfaces.Order;

@Entity
@Table(name="orders")
public class DbOrder implements Order{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private DbUser user;
	
	@Column(name="val_sell")
	private String valToSell;
	
	@Column(name="val_buy")
	private String valToBuy;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="is_open")
	private boolean isOpen;

	
	public DbOrder() {
		
	}

	public DbOrder(int id, String valToSell, String valToBuy, int amount, boolean isOpen, DbUser user) {
		super();
		this.id = id;
		this.valToSell = valToSell;
		this.valToBuy = valToBuy;
		this.amount = amount;
		this.isOpen = isOpen;
		this.user = user;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValToSell() {
		return valToSell;
	}

	public void setValToSell(String valToSell) {
		this.valToSell = valToSell;
	}

	public String getValToBuy() {
		return valToBuy;
	}

	public void setValToBuy(String valToBuy) {
		this.valToBuy = valToBuy;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public DbUser getUser() {
		return user;
	}

	public void setUser(DbUser user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", valToSell=" + valToSell + ", valToBuy=" + valToBuy + ", amount=" + amount
				+ ", isOpen=" + isOpen + "]";
	}

	@Override
	public int getUserId() {
		return this.getUser().getId();
	}

	@Override
	public String getCurrencyToSell() {
		return this.valToSell;
	}

	@Override
	public String getCurrencyToBuy() {
		return this.valToBuy;
	}
}
