package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DAO;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private DAO dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.example.demo.Entity.DbUser user = dao.findByUsername(username);
		
		if (user == null)
			throw new UsernameNotFoundException(username);
//		System.out.println("user in service: "+ user);
//		return new MyUser(user.getUsername(), user.getPassword(), user.getWallet());
		return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
	}
	
}
