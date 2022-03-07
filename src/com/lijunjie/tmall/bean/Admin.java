package com.lijunjie.tmall.bean;

public class Admin {

	private String name;
	private String password;

	public Admin() {
		super();
	}

	public Admin(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [name=" + name + ", password=" + password + "]";
	}

	
}