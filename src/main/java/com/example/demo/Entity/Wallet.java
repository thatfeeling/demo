package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="wallet")
public class Wallet {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private int id;
	
	@Column(name = "BTC")
	private double BTC;
	
	@Column(name = "ETH")
	private double ETH;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "wallet")
	private User user;
	
	public Wallet() {
		
	}

	public Wallet(int id, double bTC, double eTH, User user) {
		super();
		this.id = id;
		BTC = bTC;
		ETH = eTH;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBTC() {
		return BTC;
	}

	public void setBTC(double bTC) {
		BTC = bTC;
	}

	public double getETH() {
		return ETH;
	}

	public void setETH(double eTH) {
		ETH = eTH;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Wallet [id=" + id + ", BTC=" + BTC + ", ETH=" + ETH + "]";
	}
}
