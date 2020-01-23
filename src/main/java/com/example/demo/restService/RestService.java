package com.example.demo.restService;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.BusinessLogic.BusinessLogic;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@SpringBootApplication
public class RestService {
	
	BusinessLogic bl;
	public RestService(BusinessLogic bl) {
		this.bl = bl;
	}
	
	
	@RequestMapping(value = "/register")
	public boolean registerUser() {
		return bl.registerUser("2","3","4");
	}
	
	@RequestMapping(value = "/")
	public String hello() {
		
		bl.getAllUsers();
		
		return "Hello World";
	}
	
}
