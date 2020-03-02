package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entity.DbOrder;


public interface OrderRepository extends CrudRepository<DbOrder, Integer>{

}
