package com.example.demo.BusinessLogic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DAO;
import com.example.demo.sharedInterfaces.Order;
import com.example.demo.sharedInterfaces.User;
import com.example.demo.sharedInterfaces.Wallet;

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

	private void wallet(String currencyToSell, String currencyToBuy, double amount, BoUser user) {
		if (currencyToSell.equals("BTC")) {
			user.getWallet().setBTC(user.getWallet().getBTC() - amount);
			user.getWallet().setETH(user.getWallet().getETH() + amount);
		} else {
			user.getWallet().setETH(user.getWallet().getETH() - amount);
			user.getWallet().setBTC(user.getWallet().getBTC() + amount);
		}
	}
	
	@Override
	public <E> List<BoOrder> getMarket(int userId) {
		List<E> temp = (List<E>) dao.getMarket(userId);
		
		List<BoOrder> orders = new ArrayList<>();
		
		for (Object o : temp) {
			BoOrder order = new BoOrder();
			order.setId( ((Order)o).getId() );
			order.setAmount( ((Order)o).getAmount() );
			order.setCurrencyToBuy(((Order)o).getCurrencyToBuy());
			order.setCurrencyToSell( ((Order)o).getCurrencyToSell());
			order.setUserId( ((Order)o).getUserId());
			orders.add(order);
		}
		return orders;
	}
	
	private <E> List<BoOrder> fixOrders(List<E> temp) {
		
		List<BoOrder> orders = new ArrayList<>();
		
		for (Object ob : temp) {
			BoOrder bo = new BoOrder();
			bo.setAmount( ((Order)ob).getAmount() );
			bo.setCurrencyToBuy(((Order)ob).getCurrencyToBuy());
			bo.setCurrencyToSell( ((Order)ob).getCurrencyToSell() );
			bo.setUserId( ((Order)ob).getUserId() );
			bo.setId( ((Order)ob).getId() );
			orders.add(bo);
		}
		

		
		return orders;
		
	}
	
	private <E> BoUser fixUser(Object o) {
		BoUser user = new BoUser();
		user.setFirstName( ((User)o).getFirstName() );
		user.setId( ((User)o).getId() );
		user.setLastName( ((User)o).getLastName() );
		user.setPassword( ((User)o).getPassword() );
		user.setUsername( ((User)o).getUsername() );
		user.setOrders( ((User)o).getOrders() );
		
		
		BoWallet wallet = new BoWallet();
		wallet.setBTC( ((User)o).getWallet().getBTC() );
		wallet.setETH( ((User)o).getWallet().getETH() );
		wallet.setId( ((User)o).getWallet().getId() );
		
		user.setWallet( wallet );
		
		return user;
	}
	
	@Override
	public <E> void buyOrder(int orderId, int userId) {
		
		List<BoOrder> orders = new ArrayList<>();
		orders = fixOrders(dao.getOrders());
		
		BoUser user = new BoUser();
		user = fixUser(dao.findById(userId));

		
//		System.out.println("Orders in bo: " + orders);
//		System.out.println("wallet in bo: " + wallet_);
		
		System.out.println("orders bef: " + orders + " wallet bef: " + user.getWallet());
		for (BoOrder order_: orders) {
			if (order_.getId() == orderId) {

				
				BoUser seller = new BoUser();
				seller = fixUser(dao.findById(order_.getUserId()));
				
				if (order_.getCurrencyToSell().equalsIgnoreCase("BTC")) {
					if (order_.getAmount() > user.getWallet().getBTC())
						break;
					
					user.getWallet().setETH(user.getWallet().getETH() - order_.getAmount());
					seller.getWallet().setETH(seller.getWallet().getETH() + order_.getAmount());
					user.getWallet().setBTC(user.getWallet().getBTC() + order_.getAmount());
					seller.getWallet().setBTC(seller.getWallet().getBTC() - order_.getAmount());
				} else if (order_.getCurrencyToSell().equalsIgnoreCase("ETH")) {
					if (order_.getAmount() > user.getWallet().getETH())
						break;
					
					user.getWallet().setBTC(user.getWallet().getBTC() - order_.getAmount());
					seller.getWallet().setBTC(seller.getWallet().getBTC() + order_.getAmount());
					user.getWallet().setETH(user.getWallet().getETH() + order_.getAmount());
					seller.getWallet().setETH(seller.getWallet().getETH() - order_.getAmount());
				}
				orders.remove(order_);

				System.out.println("orders efter: " + orders + " wallet after: " + user.getWallet() + " seller: " + seller.getWallet());
				
				
				dao.removeOrder(orderId);
				dao.updateWallet(user.getWallet());
				dao.updateWallet(seller.getWallet());
				
				break;
			}
		}
		
		
	}
	
	@Override
	public <E>void processOrder(String currencyToSell, String currencyToBuy, double amount, int userId) {
		
		dao.processOrder(currencyToSell, currencyToBuy, amount, userId);
		
		
//		List<E> temp = (List<E>) dao.getOrders();
//		List<BoOrder> orders = new ArrayList<>();
//		BoUser user = new BoUser();
//		Object o = dao.findById(userId);
//		
//		user.setFirstName( ((User)o).getFirstName() );
//		user.setId( ((User)o).getId() );
//		user.setLastName( ((User)o).getLastName() );
//		user.setPassword( ((User)o).getPassword() );
//		user.setUsername( ((User)o).getUsername() );
//		user.setWallet( ((User)o).getWallet() );
//
//		
//		System.out.println(temp);
//		BoOrder order = new BoOrder(userId, currencyToSell, currencyToBuy, amount);
//		for (Object ob : temp) {
//			BoOrder bo = new BoOrder();
//			bo.setAmount( ((Order)ob).getAmount() );
//			bo.setCurrencyToBuy(((Order)ob).getCurrencyToBuy());
//			bo.setCurrencyToSell( ((Order)ob).getCurrencyToSell() );
//			bo.setUserId( ((Order)ob).getUserId() );
//			orders.add(bo);
//		}
//		
//		for (int i=0; i<orders.size(); i++) {
//			if (orders.get(i).getUserId() != userId 
//					&& orders.get(i).getCurrencyToBuy().equals(order.getCurrencyToSell())) {
//				if (orders.get(i).getAmount() - order.getAmount() > 0) {
//					orders.get(i).setAmount(orders.get(i).getAmount() - order.getAmount());
//					wallet(currencyToSell, currencyToBuy, amount, user);
//					break;
//
//				} else if (orders.get(i).getAmount() - amount < 0) {
//					order.setAmount(order.getAmount() - orders.get(i).getAmount());
//					wallet(currencyToSell, currencyToBuy, amount, user);
//					orders.remove(i);
//				}
//				else if (orders.get(i).getAmount() - amount == 0){
//					orders.remove(i);
//					wallet(currencyToSell, currencyToBuy, amount, user);
//				}
//				else {
//					dao.processOrder(currencyToSell, currencyToBuy, amount, userId);
//				}
//	
//			}
//		}
//		dao.placeOrders(orders);
//		System.out.println("orders in rest: " + orders);
	
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
