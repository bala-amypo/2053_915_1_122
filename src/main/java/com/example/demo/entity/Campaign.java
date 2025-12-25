package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Campaign {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Double budget;
    private boolean active;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getBudget() { return budget; }
    public void setBudget(Double budget) { this.budget = budget; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
