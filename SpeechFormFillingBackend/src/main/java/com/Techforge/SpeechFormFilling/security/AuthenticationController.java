package com.Techforge.SpeechFormFilling.security;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Techforge.SpeechFormFilling.Dto.LoginRequest;
import com.Techforge.SpeechFormFilling.Dto.LoginResponse;
import com.Techforge.SpeechFormFilling.Dto.SignupRequest;
import com.Techforge.SpeechFormFilling.Dto.SignupResponse;





@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authService;

    public AuthenticationController(AuthenticationService authService) {
        this.authService = authService;
    }


    @PostMapping("/register")
    public ResponseEntity<SignupResponse> register(@RequestBody SignupRequest request) {
    	SignupResponse response=authService.register(request);
    		return new ResponseEntity<>(response, HttpStatus.OK);
    	
    	
    	
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        LoginResponse response= authService.authenticate(request);
        
        return new ResponseEntity<>(response, HttpStatus.OK);
        
        
    }
    
    @GetMapping("/user_only")
    public String users() {
    	return "user only url";
    }
}
