package com.example.demo.BusinessLogic;

public interface BusinessLogic {
	
	void getAllUsers();
	boolean registerUser(String userName, String password, String email, String roles, String firstName, String lastName, 
	boolean emailConfirmed, String stateAddress, String postIndex, String country, String phoneNumber);
	<E> BoUser findByName(String username);
	<E>void processOrder(String currencyToSell, String currencyToBuy, double amount, int userId);
	String getUserInfo(String userName);
	
}
