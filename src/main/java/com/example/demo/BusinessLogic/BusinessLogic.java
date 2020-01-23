package com.example.demo.BusinessLogic;

public interface BusinessLogic {
	
	void getAllUsers();
	boolean registerUser(String userName, String password, String email);
	
}
