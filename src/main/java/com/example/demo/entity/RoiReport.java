package com.example.demo.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "roi_reports")
public class RoiReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "campaign_id")
    private Campaign campaign;

    @ManyToOne
    @JoinColumn(name = "influencer_id")
    private Influencer influencer;

    @Column(nullable = false)
    private BigDecimal totalSales;

    @Column(nullable = false)
    private BigDecimal totalRevenue;

    @Column(nullable = false)
    private BigDecimal roiPercentage;

    private Timestamp generatedAt;

    @PrePersist
    protected void onCreate() {
        this.generatedAt = new Timestamp(System.currentTimeMillis());
    }

    // ===== Getters & Setters =====

    public Long getId() {
        return id;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public Influencer getInfluencer() {
        return influencer;
    }

    public void setInfluencer(Influencer influencer) {
        this.influencer = influencer;
    }

    public BigDecimal getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(BigDecimal totalSales) {
        this.totalSales = totalSales;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public BigDecimal getRoiPercentage() {
        return roiPercentage;
    }

    public void setRoiPercentage(BigDecimal roiPercentage) {
        this.roiPercentage = roiPercentage;
    }

    public Timestamp getGeneratedAt() {
        return generatedAt;
    }
}
