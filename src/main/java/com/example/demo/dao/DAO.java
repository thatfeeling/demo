package com.example.demo.dao;

import java.util.List;

import com.example.demo.Entity.DbUser;

public interface DAO {
	
	DbUser findByUsername(String username);
	void registerUser(String userName, String password, String email, String roles, String firstName, String lastName, 
	boolean emailConfirmed, String stateAddress, String postIndex, String country, String phoneNumber) throws Exception;
	boolean varifyUser(String userName, String password);
	void getAllUsers();
	DbUser getUserInfo(String username);
	boolean processOrder(String currencyToSell, String currencyToBuy, double amount, int userId);
}
