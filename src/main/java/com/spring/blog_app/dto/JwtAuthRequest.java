package com.spring.blog_app.dto;

public class JwtAuthRequest {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public JwtAuthRequest setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public JwtAuthRequest setPassword(String password) {
        this.password = password;
        return this;
    }
}
