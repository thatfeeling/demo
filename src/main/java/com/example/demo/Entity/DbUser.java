package com.example.demo.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.sharedInterfaces.User;

@Entity
@Table(name="users")
public class DbUser implements User{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private int id;
	
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_details_id")
	private UserDetails userDetails;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="wallet_id")
	private DbWallet wallet;
	
	@OneToMany(mappedBy="user")
//	@JoinColumn(name="user_id")
	private List<DbOrder> orders;
	
	@Column(name = "roles")
	private String roles;
	
	public DbUser() {
		
	}

	public DbUser(int id, String username, String password, String email, UserDetails userDetails, DbWallet wallet,
			List<DbOrder> orders, String roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.userDetails = userDetails;
		this.wallet = wallet;
		this.orders = orders;
		this.roles = roles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public DbWallet getWallet() {
		return wallet;
	}

	public void setWallet(DbWallet wallet) {
		this.wallet = wallet;
	}

	public List<DbOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<DbOrder> orders) {
		this.orders = orders;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", userDetails=" + userDetails + ", wallet=" + wallet + ", orders=" + orders + ", roles=" + roles
				+ "]";
	}

	@Override
	public String getFirstName() {
		return this.userDetails.getFirstName();
	}

	@Override
	public String getLastName() {
		return this.userDetails.getLastName();
	}
}