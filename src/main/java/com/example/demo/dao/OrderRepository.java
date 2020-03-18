package com.example.demo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entity.DbOrder;


public interface OrderRepository extends CrudRepository<DbOrder, Integer>{
	
	
	
	@Query(value = "SELECT * FROM orders WHERE user_id != :userId", nativeQuery = true)
//	@Query(value = "SELECT * FROM USERS WHERE EMAIL_ADDRESS = ?1", nativeQuery = true)
	OrderRepository findMarket(int userId);
}
