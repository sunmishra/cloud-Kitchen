package com.serviceonepavilion.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CustomerInventory")
public class Customer {
	@Id
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String password;
	@Column(unique = true)
	private String email;
	@Column
	private String mobNo;

	public Customer() {
	}

	public Customer(int id, String name, String password, String email, String mobNo) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.mobNo = mobNo;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", mobNo="
				+ mobNo + "]";
	}

	

	
}
