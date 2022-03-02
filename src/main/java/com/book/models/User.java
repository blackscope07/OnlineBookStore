package com.book.models;

public class User {
	
	String fristname;
	String lastname;
	String address;
	
	long phoneno;
	String emailId;
	String username;
	String password;
	
	@Override
	public String toString() {
		return "User [fristname=" + fristname + ", lastname=" + lastname + ", address=" + address + ", phoneno="
				+ phoneno + ", emailId=" + emailId + ", username=" + username + ", password=" + password + "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String fristname, String lastname, String address, long phoneno, String emailId, String username,
			String password) {
		super();
		this.fristname = fristname;
		this.lastname = lastname;
		this.address = address;
		this.phoneno = phoneno;
		this.emailId = emailId;
		this.username = username;
		this.password = password;
	}
	public String getFristname() {
		return fristname;
	}
	public void setFristname(String fristname) {
		this.fristname = fristname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
	
	
	

}
