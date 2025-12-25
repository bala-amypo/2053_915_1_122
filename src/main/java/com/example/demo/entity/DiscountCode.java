package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class DiscountCode {

    @Id
    @GeneratedValue
    private Long id;

    private String code;
    private Double discountPercentage;

    @ManyToOne
    private Influencer influencer;

    @ManyToOne
    private Campaign campaign;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public Double getDiscountPercentage() { return discountPercentage; }
    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Influencer getInfluencer() { return influencer; }
    public void setInfluencer(Influencer influencer) {
        this.influencer = influencer;
    }

    public Campaign getCampaign() { return campaign; }
    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }
}
