package com.Techforge.SpeechFormFilling.security;

public class AuthenticationResponse {
    private String token;
    private String message;

    public AuthenticationResponse(String token, String message) {
        this.token = token;
        this.message = message;
    }

    public AuthenticationResponse() {
		// TODO Auto-generated constructor stub
	}

	public String getToken() {
        return token;
    }

    public String getMessage() {
        return message;
    }

	public void setToken(String token) {
		this.token = token;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
    
}
