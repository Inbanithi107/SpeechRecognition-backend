package com.Techforge.SpeechFormFilling.Dto;

public class Frontend {
	
	private String message;
	
	private boolean auth;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isAuth() {
		return auth;
	}

	public void setAuth(boolean auth) {
		this.auth = auth;
	}

	public Frontend(String message, boolean auth) {
		
		this.message = message;
		this.auth = auth;
	}
	
	

}
