package com.example.demo.BusinessLogic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DAO;
import com.example.demo.sharedInterfaces.Order;
import com.example.demo.sharedInterfaces.User;

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
	public <E> BoUser findByName(String username) {
		Object o = dao.findByUsername(username);
		
		BoUser user = new BoUser();
		user.setUsername(((User)o).getUsername());
		user.setPassword(((User)o).getPassword());
		user.setFirstName(((User)o).getFirstName());
		user.setLastName(((User)o).getLastName());
		user.setId(((User)o).getId());
		user.setOrders(((User)o).getOrders());
		
		BoWallet wallet = new BoWallet();
		wallet.setBTC(((User)o).getWallet().getBTC());
		wallet.setETH(((User)o).getWallet().getETH());
		
		List<Order> ords = ((User)o).getOrders();
		List<BoOrder> orders = new ArrayList<BoOrder>();
		
		for (Order or : ords) {
			BoOrder order = new BoOrder();
			order.setCurrencyToSell(or.getCurrencyToSell());
			order.setCurrencyToBuy(or.getCurrencyToBuy());
			order.setAmount(or.getAmount());
			orders.add(order);
			
		}
		user.setWallet(wallet);
		user.setOrders( orders );
		
		System.out.println("user in BO: " + user);
		return user;
	}

	@Override
	public <E>void processOrder(String currencyToSell, String currencyToBuy, double amount, int userId) {
		List<E> temp = (List<E>) dao.getOrders();
		List<BoOrder> orders = new ArrayList<>();
		BoUser user = new BoUser();
		Object o = dao.findById(userId);
		
		user.setFirstName( ((User)o).getFirstName() );
		user.setId( ((User)o).getId() );
		user.setLastName( ((User)o).getLastName() );
		user.setPassword( ((User)o).getPassword() );
		user.setUsername( ((User)o).getUsername() );
		user.setWallet( ((User)o).getWallet() );
		
		
		System.out.println(temp);
		BoOrder order = new BoOrder(userId, currencyToSell, currencyToBuy, amount);
		for (Object ob : temp) {
			BoOrder bo = new BoOrder();
			bo.setAmount( ((Order)ob).getAmount() );
			bo.setCurrencyToBuy(((Order)ob).getCurrencyToBuy());
			bo.setCurrencyToSell( ((Order)ob).getCurrencyToSell() );
			bo.setUserId( ((Order)ob).getUserId() );
			orders.add(bo);
		}
		
		for (int i=0; i<orders.size(); i++) {
			if (orders.get(i).getUserId() != userId 
					&& orders.get(i).getCurrencyToBuy().equals(order.getCurrencyToSell())) {
				if (orders.get(i).getAmount() - order.getAmount() > 0) {
					orders.get(i).setAmount(orders.get(i).getAmount() - order.getAmount());
					
//					dao.updateWallet(userId, newBtc, newEth);
//					
//					dao.placeOrders(orders);
					
				} else if (orders.get(i).getAmount() - amount < 0) {
					
				}
				else {
					orders.remove(i);
				}
	
			}
		}
		
		System.out.println("orders in rest: " + orders);
	
//		System.out.println(dao.processOrder(currencyToSell, currencyToBuy, amount, userId));
		
	}

	@Override
	public String getUserInfo(String userName) {
		BoUser user = new BoUser();
		Object o = dao.getUserInfo(userName);
		
		user.setUsername(((User)o).getUsername());
		user.setPassword(((User)o).getPassword());
		
		BoWallet wallet = new BoWallet();
		wallet.setBTC(((User)o).getWallet().getBTC());
		wallet.setETH(((User)o).getWallet().getETH());
		user.setWallet(wallet);
		System.out.println("user in BO: " + user);
		return "";
	}

}
