package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.example.demo.Entity.DbWallet;


@Repository
public interface WalletRepository extends CrudRepository<DbWallet, Integer>{

}
