package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class RoiReport {

    @Id
    @GeneratedValue
    private Long id;

    private BigDecimal revenue;
    private BigDecimal cost;
    private Double roiPercentage;

    @ManyToOne
    private Influencer influencer;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public BigDecimal getRevenue() { return revenue; }
    public void setRevenue(BigDecimal revenue) {
        this.revenue = revenue;
    }

    public BigDecimal getCost() { return cost; }
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Double getRoiPercentage() { return roiPercentage; }
    public void setRoiPercentage(Double roiPercentage) {
        this.roiPercentage = roiPercentage;
    }

    public Influencer getInfluencer() { return influencer; }
    public void setInfluencer(Influencer influencer) {
        this.influencer = influencer;
    }
}
