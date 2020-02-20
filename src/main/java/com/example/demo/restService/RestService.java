package com.example.demo.restService;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.BusinessLogic.BusinessLogic;
import com.example.demo.jwt.JwtRequest;
import com.example.demo.jwt.JwtResponse;
import com.example.demo.jwt.JwtUtil;
import com.example.demo.services.MyUserDetailsService;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@SpringBootApplication
public class RestService {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@Autowired
	private BusinessLogic bl;
	
	
	@RequestMapping(value = "/findname")
	public String find() {
		bl.findByName();
		return "lol";
	}
	
	@RequestMapping(value = "/register")
	public boolean registerUser() {
		return bl.registerUser("anders", "pass", "anders@kth.se", "USER", "Anders", "Lindstrom", true, "Stockholm", "1488", "Sweden", "9966992211");
	}
	
	@RequestMapping(value = "/")
	public String hello() {
		bl.getAllUsers();
		return "Hello World";
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		System.out.println("jwt: " + jwtRequest.getUsername() + " " + jwtRequest.getPassword());
		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception ("Incorrect username or password", e);
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getUsername());
		
		final String jwt = jwtTokenUtil.generateToken(userDetails);

		System.out.println(jwt);
		return ResponseEntity.status(HttpStatus.OK).header("Auth ", jwt).build();
	}
}
