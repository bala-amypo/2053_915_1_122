package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.time.LocalDate;

@Entity
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String campaignName;
    private LocalDate startDate;
    private LocalDate endDate;

    // getters and setters
    public Long getId() { 
        return id; 
    }

    public void setId(Long id) { 
        this.id = id; 
    }

    public String getCampaignName() { 
        return campaignName; 
    }

    public void setCampaignName(String campaignName) { 
        this.campaignName = campaignName; 
    }

    public LocalDate getStartDate() { 
        return startDate; 
    }

    public void setStartDate(LocalDate startDate) { 
        this.startDate = startDate; 
    }

    public LocalDate getEndDate() { 
        return endDate; 
    }

    public void setEndDate(LocalDate endDate) { 
        this.endDate = endDate; 
    }
}
