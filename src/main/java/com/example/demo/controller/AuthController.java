package com.example.demo.controller;

import com.example.demo.security.JwtUtil;

public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }
}