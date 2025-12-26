package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String role;
    private boolean active;

    // ✅ MUST remain Timestamp (test requires it)
    private Timestamp createdAt;

    // ===== Getters & Setters =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    // ✅ Test reads this as Timestamp
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    // ✅ Test sometimes passes Timestamp
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    // ✅ Test sometimes passes LocalDateTime
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = Timestamp.valueOf(createdAt);
    }
}
