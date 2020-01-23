package com.example.demo.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private int id;
	
	@Column(name = "user_name", nullable = false)
	private String userName;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "email_confirmed")
	private boolean emailConfirmed;
	
	@Column(name = "last_login")
	private int lastLogin;
	
	@Column(name = "reg_date")
	private int regDate;
	
	@Column(name = "user_hash")
	private String userHash;
	
	@Column(name = "prem")
	private boolean prem;
	
	@Column(name = "secret")
	private String secret;
	
	@Column(name = "2fa")
	private boolean twoFa;
	
	@Column(name = "refferal")
	private String refferal;
	
	@Column(name = "ref_check")
	private int refCheck;
	
	protected User() {
		
	}

	public User(int id, String userName, String password, String email, boolean emailConfirmed, int lastLogin, int regDate,
			String userHash, boolean prem, String secret, boolean twoFa, String refferal, int refCheck) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.emailConfirmed = emailConfirmed;
		this.lastLogin = lastLogin;
		this.regDate = regDate;
		this.userHash = userHash;
		this.prem = prem;
		this.secret = secret;
		this.twoFa = twoFa;
		this.refferal = refferal;
		this.refCheck = refCheck;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLogin() {
		return userName;
	}


	public void setLogin(String userName) {
		this.userName = userName;
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


	public boolean isEmailConfirmed() {
		return emailConfirmed;
	}


	public void setEmailConfirmed(boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}


	public int getLastLogin() {
		return lastLogin;
	}


	public void setLastLogin(int lastLogin) {
		this.lastLogin = lastLogin;
	}


	public int getRegDate() {
		return regDate;
	}


	public void setRegDate(int regDate) {
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


	public boolean isTwoFa() {
		return twoFa;
	}


	public void setTwoFa(boolean twoFa) {
		this.twoFa = twoFa;
	}


	public String getRefferal() {
		return refferal;
	}


	public void setRefferal(String refferal) {
		this.refferal = refferal;
	}


	public int getRefCheck() {
		return refCheck;
	}


	public void setRefCheck(int refCheck) {
		this.refCheck = refCheck;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", emailConfirmed=" + emailConfirmed + ", lastLogin=" + lastLogin + ", regDate=" + regDate
				+ ", userHash=" + userHash + ", prem=" + prem + ", secret=" + secret + ", twoFa=" + twoFa
				+ ", refferal=" + refferal + ", refCheck=" + refCheck + "]";
	}
	
}