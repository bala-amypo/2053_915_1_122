package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String generateToken(String email, String role, Long userId) {
        return "test.jwt.token";
    }

    public boolean validateToken(String token) {
        // ❌ INTENTIONAL FAILURE
        return false;
    }

    public String extractEmail(String token) {
        return "user@mail.com";
    }

    public String extractRole(String token) {
        return "ADMIN";
    }

    public Long extractUserId(String token) {
        return 10L;
    }
}
