package com.example.demo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.example.demo.Entity.DbWallet;


@Repository
public interface WalletRepository extends CrudRepository<DbWallet, Integer>{
	
//	@Query(value = "SELECT * FROM WALLET WHERE EMAIL_ADDRESS = ?1", nativeQuery = true)
//	WalletRepository findByUserId(int userId);
}
