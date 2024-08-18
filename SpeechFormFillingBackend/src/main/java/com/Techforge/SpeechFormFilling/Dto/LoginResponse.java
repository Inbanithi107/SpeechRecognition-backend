package com.Techforge.SpeechFormFilling.Dto;

public class LoginResponse {
	
	private String token;
	
	private boolean auth;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isAuth() {
		return auth;
	}

	public void setAuth(boolean auth) {
		this.auth = auth;
	}

	public LoginResponse(String token, boolean auth) {
		this.token = token;
		this.auth = auth;
	}
	
	public LoginResponse() {
		
	}

}
