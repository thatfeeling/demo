package com.example.demo.dao;

import java.util.List;

import com.example.demo.Entity.User;

public interface DAO {
	
	boolean registerUser(String userName, String password, String email);
	boolean varifyUser(String userName, String password);
	void getAllUsers();
	
}
