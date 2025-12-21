package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

@Entity
public class RoiReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal totalSales;
    private int totalTransactions;
    private double roiPercentage;

    @ManyToOne
    private DiscountCode discountCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotalSales() { 
        return totalSales; 
    }

    public void setTotalSales(BigDecimal totalSales) { 
        this.totalSales = totalSales; 
    }

    public int getTotalTransactions() { 
        return totalTransactions; 
    }

    public void setTotalTransactions(int totalTransactions) { 
        this.totalTransactions = totalTransactions; 
    }

    public double getRoiPercentage() { 
        return roiPercentage; 
    }

    public void setRoiPercentage(double roiPercentage) { 
        this.roiPercentage = roiPercentage; 
    }

    public DiscountCode getDiscountCode() { 
        return discountCode; 
    }

    public void setDiscountCode(DiscountCode discountCode) { 
        this.discountCode = discountCode; 
    }
}
