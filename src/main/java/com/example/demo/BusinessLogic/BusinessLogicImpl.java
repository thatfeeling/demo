package com.example.demo.BusinessLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DAO;

@Service
public class BusinessLogicImpl implements BusinessLogic{
	
	DAO dao;
	
	@Autowired
	public BusinessLogicImpl(DAO dao) {
		this.dao = dao;
	}

	@Override
	public void getAllUsers() {
		dao.getAllUsers();
	}
	
	@Override
	public boolean registerUser(String userName, String password, String email) {
		return dao.registerUser(userName, password, email);
	}

}
