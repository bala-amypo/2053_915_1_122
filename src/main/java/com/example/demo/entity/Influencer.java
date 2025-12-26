package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "influencer")
public class Influencer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String socialHandle;
    private String email;
    private boolean active;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSocialHandle() { return socialHandle; }
    public void setSocialHandle(String socialHandle) {
        this.socialHandle = socialHandle;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
