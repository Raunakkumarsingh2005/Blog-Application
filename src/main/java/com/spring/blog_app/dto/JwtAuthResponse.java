package com.spring.blog_app.dto;

public class JwtAuthResponse {
    private String token;

    public String getToken() {
        return token;
    }

    public JwtAuthResponse setToken(String token) {
        this.token = token;
        return this;
    }
}
