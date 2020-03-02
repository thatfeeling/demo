package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.example.demo.Entity.DbUser;
@Repository
public interface UserRepository extends CrudRepository<DbUser, Integer> {
	
	UserRepository findByUsername(String username);
}
