package com.mainclass.bean;

import org.springframework.stereotype.Component;
@Component
public class Admin {
	private String userld;
	private String password;
	
	public Admin() {
	}
	public Admin(String userld, String password) {
		super();
		this.userld = userld;
		this.password = password;
	}
	public String getUserld() {
		return userld;
	}
	public void setUserld(String userld) {
		this.userld = userld;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
