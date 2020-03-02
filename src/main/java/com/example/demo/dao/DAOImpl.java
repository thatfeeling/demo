package com.example.demo.dao;


import com.example.demo.Entity.DbOrder;
import com.example.demo.Entity.DbUser;
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
	
	@Autowired
	private WalletRepository walletRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	public DAOImpl() {

	}
	
	@Override
	public DbUser findByUsername(String username) {
		DbUser u = null; 
		List<DbUser> users = (List<DbUser>) userRepository.findAll();
		for (DbUser us : users) {
			if (us.getUsername().equals(username))
				u = us;
		}
		System.out.println("user in db: " + u);
		return u;
	}
	
	@Override
	public boolean varifyUser(String userName, String password) {
		return false;
	}

	@Override
	@Transactional
	public void getAllUsers() {
		List<DbUser> users = (List<DbUser>) userRepository.findAll();
		System.out.println(users);
	
	}

	@Override
	@Transactional
	public void registerUser(String username, String password, String email, String roles, String firstName, String lastName, 
			boolean emailConfirmed, String stateAddress, String postIndex, String country, String phoneNumber) throws Exception{
		DbUser u = new DbUser();
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

	@Override
	public DbUser getUserInfo(String username) {
		userRepository.findByUsername(username);
		DbUser u = new DbUser();
		
		return u;
	}
	
	private DbUser findById(int userId) {
		return userRepository.findById(userId).get();
	}

	@Override
	@Transactional
	public boolean processOrder(String currencyToSell, String currencyToBuy, double amount, int userId) {
		DbOrder o = new DbOrder();
		o.setValToSell(currencyToSell);
		o.setValToBuy(currencyToBuy);
		o.setAmount(amount);
		
		o.setUser(findById(userId));
		o.setOpen(true);
		orderRepository.save(o);
		return true;
	}

}
