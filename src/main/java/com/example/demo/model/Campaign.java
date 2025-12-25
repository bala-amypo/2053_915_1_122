package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Campaign {

    @Id
    @GeneratedValue
    private Long id;

    private String campaignName;
    private Double budget;
    private boolean active;

    private LocalDate startDate;
    private LocalDate endDate;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCampaignName() { return campaignName; }
    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public Double getBudget() { return budget; }
    public void setBudget(Double budget) { this.budget = budget; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
