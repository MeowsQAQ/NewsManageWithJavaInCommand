package com.qksoft.entity;

import java.io.Serializable;
import java.sql.Date;

public class Customer implements Serializable{

	private Integer id;
	private String name;
	private String email;
	private Date birth;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomerName() {
		return name;
	}

	public void setCustomerName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email
				+ ", birth=" + birth + "]";
	}

	public Customer(Integer id, String name, String email, Date birth) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.birth = birth;
	}
	
	
	
	public Customer(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

}
