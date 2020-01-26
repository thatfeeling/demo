package com.example.demo.BusinessLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DAO;

@Service
public class BusinessLogicImpl implements BusinessLogic{
	
	@Autowired
	DAO dao;

	@Override
	public void getAllUsers() {
		dao.getAllUsers();
	}
	
	@Override
	public boolean registerUser(String userName, String password, String email, String roles, String firstName, String lastName, 
			boolean emailConfirmed, String stateAddress, String postIndex, String country, String phoneNumber) {
		try { 
			dao.registerUser(userName, password, email, roles, firstName, lastName, emailConfirmed, stateAddress, postIndex, country, phoneNumber);
			return true;
		} catch (Exception e) {
			System.out.println("bo error: " + e.getCause());
		}
		return false;
	}

	@Override
	public String findByName() {
		dao.findByUsername("anton");
		return "lol";
	}

}
