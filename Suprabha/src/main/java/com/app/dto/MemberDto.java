package com.app.dto;

import javax.validation.constraints.NotEmpty;

public class MemberDto {
@NotEmpty
private String name;
private String Email;
private String password;
private String address;
public MemberDto(@NotEmpty String name, String email, String password, String address) {
	super();
	this.name = name;
	Email = email;
	this.password = password;
	this.address = address;
}
public MemberDto() {
	super();
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
@Override
public String toString() {
	return "MemberDto [name=" + name + ", Email=" + Email + ", password=" + password + ", address=" + address + "]";
}

}
