package com.Techforge.SpeechFormFilling.security;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Techforge.SpeechFormFilling.Dto.LoginRequest;
import com.Techforge.SpeechFormFilling.Dto.LoginResponse;
import com.Techforge.SpeechFormFilling.Dto.SignupRequest;
import com.Techforge.SpeechFormFilling.Dto.SignupResponse;


import java.io.File;
import java.util.List;
import java.util.Optional;

@Service
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository repository,
                                 PasswordEncoder passwordEncoder,
                                 JwtService jwtService,
                                 AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        
        this.authenticationManager = authenticationManager;
    }

    public SignupResponse register(SignupRequest request) {

        // check if user already exist. if exist than authenticate the user
        if(repository.findByUsername(request.getUsername()).isPresent()) {
        	SignupResponse response=new SignupResponse("user already exist", false);
            return response;
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setMobile(request.getMobile());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        repository.save(user);
       SignupResponse response = new SignupResponse("user created succesfully", true);
		return response;
        

        

        

        

    }

    public LoginResponse authenticate(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        User user = repository.findByUsername(request.getUsername()).orElseThrow();
        String jwt = jwtService.generateToken(user);
        LoginResponse response=new LoginResponse(jwt, true);

        

        return response;

    }
    

      
    
}
