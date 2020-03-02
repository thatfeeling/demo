package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public class UserDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email_confirmed")
	private boolean emailConfirmed;
	
	@Column(name = "st_address")
	private String stateAddress;
	
	@Column(name = "post_index")
	private String postIndex;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "last_login")
	private long lastLogin;
	
	@Column(name = "reg_date")
	private long regDate;
	
	@Column(name = "user_hash")
	private String userHash;
	
	@Column(name = "prem")
	private boolean prem;
	
	@Column(name = "secret")
	private String secret;
	
	@Column(name = "2fa")
	private boolean twofa;
	
	@Column(name = "refferal")
	private String refferal;
	
	@Column(name = "refferal_check")
	private int refferal_check;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "userDetails")
	private DbUser user;
	
	public UserDetails() {
		
	}
	
	public UserDetails(int id, String firstName, String lastName, boolean emailConfirmed, String stateAddress,
			String postIndex, String country, String phoneNumber, long lastLogin, long regDate, String userHash,
			boolean prem, String secret, boolean twofa, String refferal, int refferal_check) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailConfirmed = emailConfirmed;
		this.stateAddress = stateAddress;
		this.postIndex = postIndex;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.lastLogin = lastLogin;
		this.regDate = regDate;
		this.userHash = userHash;
		this.prem = prem;
		this.secret = secret;
		this.twofa = twofa;
		this.refferal = refferal;
		this.refferal_check = refferal_check;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isEmailConfirmed() {
		return emailConfirmed;
	}

	public void setEmailConfirmed(boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}

	public String getStateAddress() {
		return stateAddress;
	}

	public void setStateAddress(String stateAddress) {
		this.stateAddress = stateAddress;
	}

	public String getPostIndex() {
		return postIndex;
	}

	public void setPostIndex(String postIndex) {
		this.postIndex = postIndex;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public long getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(long lastLogin) {
		this.lastLogin = lastLogin;
	}

	public long getRegDate() {
		return regDate;
	}

	public void setRegDate(long regDate) {
		this.regDate = regDate;
	}

	public String getUserHash() {
		return userHash;
	}

	public void setUserHash(String userHash) {
		this.userHash = userHash;
	}

	public boolean isPrem() {
		return prem;
	}

	public void setPrem(boolean prem) {
		this.prem = prem;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public boolean isTwofa() {
		return twofa;
	}

	public void setTwofa(boolean twofa) {
		this.twofa = twofa;
	}

	public String getRefferal() {
		return refferal;
	}

	public void setRefferal(String refferal) {
		this.refferal = refferal;
	}

	public int getRefferal_check() {
		return refferal_check;
	}

	public void setRefferal_check(int refferal_check) {
		this.refferal_check = refferal_check;
	}
	
	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailConfirmed="
				+ emailConfirmed + ", stateAddress=" + stateAddress + ", postIndex=" + postIndex + ", country=" + country
				+ ", phoneNumber=" + phoneNumber + ", lastLogin=" + lastLogin + ", regDate=" + regDate + ", userHash="
				+ userHash + ", prem=" + prem + ", secret=" + secret + ", twofa=" + twofa + ", refferal=" + refferal
				+ ", refferal_check=" + refferal_check + "]";
	}
}
