package com.example.demo.dao;

import java.util.List;

import com.example.demo.Entity.DbOrder;
import com.example.demo.Entity.DbUser;
import com.example.demo.Entity.DbWallet;
import com.example.demo.sharedInterfaces.Wallet;

public interface DAO {
	
	DbUser findByUsername(String username);
	void registerUser(String userName, String password, String email, String roles, String firstName, String lastName, 
	boolean emailConfirmed, String stateAddress, String postIndex, String country, String phoneNumber) throws Exception;
	boolean varifyUser(String userName, String password);
	void getAllUsers();
	DbUser getUserInfo(String username);
	boolean processOrder(String currencyToSell, String currencyToBuy, double amount, int userId);
	<E>List<DbOrder> getOrders();
	DbUser findById(int userId);
	<E> boolean placeOrders(List<E> orders);
	DbWallet getUsersWallet(int userId);
	Object getWalletById(int id);
	<E>List<DbOrder> getMarket(int userId);
	void updateWallet(Wallet wallet);
	void removeOrder(int orderId);
}
