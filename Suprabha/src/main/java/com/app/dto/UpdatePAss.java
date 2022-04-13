package com.app.dto;

public class UpdatePAss {

	
	
    private String email;
  
    private String oldpassword;
    
    private String newPassword;

	

	public UpdatePAss(String email, String oldpassword, String newPassword) {
		super();
		this.email = email;
		this.oldpassword = oldpassword;
		this.newPassword = newPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public String getOldpassword() {
		return oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@Override
	public String toString() {
		return "UpdatePAss [email=" + email + ", oldpassword=" + oldpassword + ", newPassword=" + newPassword + "]";
	}
    
    
}
