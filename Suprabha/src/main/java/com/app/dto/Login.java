package com.app.dto;

public class Login {

	
	String email;
	String passord;
	public Login(String email, String passord) {
		super();
		this.email = email;
		this.passord = passord;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassord() {
		return passord;
	}
	public void setPassord(String passord) {
		this.passord = passord;
	}
	@Override
	public String toString() {
		return "Login [email=" + email + ", passord=" + passord + "]";
	}
	
}
