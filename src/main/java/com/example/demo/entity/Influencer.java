package com.example.demo.entity;

public class Influencer {

    private int id;
    private String name;
    private String socialHandle;
    private boolean active = true;

    public Influencer() {
        
    }

    public Influencer(int id, String name, String socialHandle) {
        this.id = id;
        this.name = name;
        this.socialHandle = socialHandle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSocialHandle() {
        return socialHandle;
    }

    public void setSocialHandle(String socialHandle) {
        this.socialHandle = socialHandle;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
