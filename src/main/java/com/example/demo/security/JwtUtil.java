package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    // Secret key (should be stored securely in real apps)
    private static final Key SECRET_KEY =
            Keys.hmacShaKeyFor("my-super-secure-jwt-secret-key-123456".getBytes());

    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour

    // 🔐 Generate JWT
    public String generateToken(String email, String role, Long userId) {
        return Jwts.builder()
                .setSubject(email)
                .claim("role", role)
                .claim("userId", userId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    // ✅ Validate JWT
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    // 📧 Extract Email
    public String extractEmail(String token) {
        return extractClaims(token).getSubject();
    }

    // 🧑 Extract Role
    public String extractRole(String token) {
        return extractClaims(token).get("role", String.class);
    }

    // 🆔 Extract User ID
    public Long extractUserId(String token) {
        return extractClaims(token).get("userId", Long.class);
    }

    private Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
