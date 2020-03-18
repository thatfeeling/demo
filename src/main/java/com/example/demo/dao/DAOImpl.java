package com.example.demo.dao;


import com.example.demo.Entity.DbOrder;
import com.example.demo.Entity.DbUser;
import com.example.demo.Entity.DbWallet;
import com.example.demo.Entity.UserDetails;
import com.example.demo.sharedInterfaces.Order;
import com.example.demo.sharedInterfaces.Wallet;

import java.util.ArrayList;
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
	
	public DbUser findById(int userId) {
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
	
	@Override
	public DbWallet getUsersWallet(int userId) {
		System.out.println("in db");
//		Object o = walletRepository.findByUserId(userId);
		System.out.println("after in db");
		DbWallet wallet = new DbWallet();
//		wallet.setBTC( ((Wallet) o).getBTC());
//		wallet.setETH( ((Wallet)o).getETH() );
		System.out.println(wallet);
		return wallet;
		
	}

	@Override
	@Transactional
	public <E> boolean placeOrders(List<E> orders) {
//		orderRepository.save(order);
		return true;
	}
	
	@Override
	@Transactional
	public void removeOrder(int orderId) {
		orderRepository.deleteById(orderId);
	}
	
	@Override
	public <E> List<DbOrder> getOrders() {
		List<DbOrder> orders = new ArrayList<>();
		List<E> temp = (List<E>) orderRepository.findAll();
		
//		System.out.println("orders in dao: " + temp);
		
		return (List<DbOrder>) temp;
	}

	@Override
	public Object getWalletById(int id) {
		System.out.println("id: " + id);
		return walletRepository.findById(id).get();
	}

	@Override
	public <E> List<DbOrder> getMarket(int userId) {
		List<DbOrder> orders = new ArrayList<>();
		List<E> temp = (List<E>) orderRepository.findAll();
		
		for (Object o : temp) {
//			DbOrder order = new DbOrder();
//			order.setAmount( ((Order)o).getAmount() );
//			order.setId( ((Order)o).getId() );
			if (((Order)o).getUserId() != userId)
				orders.add(((DbOrder)o));
		}
		
//		return (List<DbOrder>) orderRepository.findMarket(userId).findAll();
		return orders;
	}

	@Override
	public void updateWallet(Wallet wallet_) {
		DbWallet wallet = new DbWallet();
		wallet.setBTC(wallet_.getBTC());
		wallet.setETH(wallet_.getETH());
		wallet.setId(wallet_.getId());
//		wallet.setUser(wallet_.get);
		walletRepository.save(wallet);
		
	}

}
