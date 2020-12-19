package com.serviceonepavilion.models;

//while creating models the fields of class must match with request parameters of view page
public class Login {
	private String email;
	private String password;

	public Login() {
	}
	
	public Login(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Login [email=" + email + ", password=" + password + "]";
	}

}
