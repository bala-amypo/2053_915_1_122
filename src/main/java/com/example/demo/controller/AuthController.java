package com.example.demo.controller;

import com.example.demo.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    // POST – login
    @PostMapping("/login")
    public String login() {
        return "login successful";
    }

    // GET – validate token
    @GetMapping("/validate")
    public boolean validate(@RequestParam String token) {
        return jwtUtil.validateToken(token);
    }

    // PUT – refresh token (concept)
    @PutMapping("/refresh")
    public String refresh() {
        return "new token";
    }
}
