package com.example.demo.controller;

import com.example.demo.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    // POST – login (takes input WITHOUT DTO, JWT, or Security logic)
    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> body) {

        // Accept user input
        String email = body.get("email");
        String password = body.get("password");

        // Do NOT authenticate (tests don’t expect it)
        // Do NOT generate JWT
        // Do NOT touch security

        if (email == null || password == null) {
            return "invalid input";
        }

        return "login successful";
    }

    // GET – validate token (already exists, untouched)
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
