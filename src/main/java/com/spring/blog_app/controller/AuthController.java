package com.spring.blog_app.controller;

import com.spring.blog_app.dto.JwtAuthRequest;
import com.spring.blog_app.dto.JwtAuthResponse;
import com.spring.blog_app.security.JwtTokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private AuthenticationManager authenticationManager;
    private CustomUserDetailsService userDetails;
    private JwtTokenHelper jwtTokenHelper;

    @Autowired
    public AuthController(AuthenticationManager authenticatioManger, CustomUserDetailsService userDetailsService, JwtTokenHelper jwtTokenHelper) {
        this.authenticationManager = authenticatioManger;
        this.userDetailsService = userDetailsService;
        this.jwtTokenHelper = jwtTokenHelper;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) {
        authenticate(request.getUsername(), request.getPassword());
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String token = jwtTokenHelper.generateToken(userDetails);
        JwtAuthResponse response = new JwtAuthResponse();
        response.setToken(token);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void authenticate(String username, String password) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);

        try{
            authenticationManager.authenticate(authToken);
        } catch (BadCredentialsException e) {
            throw new RuntimeException("Invalid username or password");
        }
    }

}
