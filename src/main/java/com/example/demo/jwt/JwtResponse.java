package com.example.demo.jwt;

public class JwtResponse {

	private final String jwtString;

	public JwtResponse(String jwtString) {
		super();
		this.jwtString = jwtString;
	}

	public String getJwtString() {
		return jwtString;
	}
	
}
