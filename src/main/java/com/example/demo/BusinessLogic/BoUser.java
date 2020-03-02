package com.example.demo.BusinessLogic;

import java.util.List;

import com.example.demo.sharedInterfaces.User;

public class BoUser implements User{
	
	private int id;
	private String username;
	private String password;
	private BoWallet wallet;
	private String firstName;
	private String lastName;
	private List<BoOrder> orders;
	
	
	
	public List<BoOrder> getOrders() {
		return  this.orders;
	}
	
	public void setOrders(List<BoOrder> orders) {
		this.orders = orders;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public BoWallet getWallet() {
		return wallet;
	}
	public void setWallet(BoWallet wallet) {
		this.wallet = wallet;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "BoUser [id=" + id + ", username=" + username + ", password=" + password + ", wallet=" + wallet
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", orders=" + orders + "]";
	}

	
}
