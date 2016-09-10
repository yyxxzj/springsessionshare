package com.npf.model;

import java.io.Serializable;

public class Student implements Serializable{

	private static final long serialVersionUID = 7022442986039971079L;
	
	private String id;
	
	private String name;
	
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		return "Student [id=" + id + ", name=" + name + ", password="
				+ password + "]";
	}
}
