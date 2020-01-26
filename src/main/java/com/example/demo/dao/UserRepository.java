package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	UserRepository findByUsername(String username);
}
