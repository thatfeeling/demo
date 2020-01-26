package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.UserDetails;

@Repository
public interface UserDetailsRepository extends CrudRepository<UserDetails, Integer> {
	
}
