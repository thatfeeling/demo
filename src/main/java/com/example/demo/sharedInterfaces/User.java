package com.example.demo.sharedInterfaces;

import java.util.List;

public interface User {
	
	int getId();
	String getUsername();
	String getPassword();
	String getFirstName();
	String getLastName();
	Wallet getWallet();
	<E> List<E> getOrders();
}
