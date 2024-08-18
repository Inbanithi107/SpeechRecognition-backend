package com.Techforge.SpeechFormFilling.Dto;

import org.springframework.web.multipart.MultipartFile;

import com.Techforge.SpeechFormFilling.security.Role;


public class SignupRequest {
	
	private String username;
	
	private String password;
	
	private String email;
	
	private String mobile;
	
	private Role role;
	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	

	public SignupRequest(String username, String password, String email, String mobile, Role role) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		this.role = role;
		
	}
	
	public SignupRequest() {
		
	}
	
	

}
