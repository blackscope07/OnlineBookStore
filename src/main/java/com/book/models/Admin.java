package com.book.models;

public class Admin {
	int adminid;
	String Emplyname;
	String password;
	
	
	@Override
	public String toString() {
		return "Admin [adminid=" + adminid + ", Emplyname=" + Emplyname + ", password=" + password + "]";
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(int adminid, String emplyname, String password) {
		super();
		this.adminid = adminid;
		Emplyname = emplyname;
		this.password = password;
	}
	public int getAdminid() {
		return adminid;
	}
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	public String getEmplyname() {
		return Emplyname;
	}
	public void setEmplyname(String emplyname) {
		Emplyname = emplyname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
}
