package com.example.demo.dao;


import com.example.demo.Entity.User;
import com.example.demo.Entity.UserDetails;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DAOImpl implements DAO {

	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	public DAOImpl() {

	}
	
	@Override
	public User findByUsername(String username) {
		User u = null; 
		List<User> users = (List<User>) userRepository.findAll();
		for (User us : users) {
			if (us.getUsername().equals(username))
				u = us;
		}
		System.out.println(u);
		return u;
	}
	
	@Override
	public boolean varifyUser(String userName, String password) {
		return false;
	}

	@Override
	@Transactional
	public void getAllUsers() {
		List<User> users = (List<User>) userRepository.findAll();
		System.out.println(users);
	
	}

	@Override
	@Transactional
	public void registerUser(String username, String password, String email, String roles, String firstName, String lastName, 
			boolean emailConfirmed, String stateAddress, String postIndex, String country, String phoneNumber) throws Exception{
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		u.setEmail(email);
		u.setRoles(roles);
		
		
		UserDetails ud = new UserDetails();
		ud.setFirstName(firstName);
		ud.setLastName(lastName);
		ud.setEmailConfirmed(emailConfirmed);
		ud.setStateAddress(stateAddress);
		ud.setPostIndex(postIndex);
		ud.setCountry(country);
		ud.setPhoneNumber(phoneNumber);
		ud.setRegDate(System.currentTimeMillis()/1000);
		 
		u.setUserDetails(ud);
		
		userDetailsRepository.save(ud);
		userRepository.save(u);
	}

}
