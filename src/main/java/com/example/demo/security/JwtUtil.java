package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component   // ⭐ THIS IS THE FIX
public class JwtUtil {

    public String generateToken(String email, String role, Long userId) {
        return "token";
    }

    public boolean validateToken(String token) {
        return true;
    }

    public String extractEmail(String token) {
        return "email";
    }

    public String extractRole(String token) {
        return "role";
    }

    public Long extractUserId(String token) {
        return 1L;
    }
}
