package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
public class SaleTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private BigDecimal transactionAmount;
    private Timestamp transactionDate;

    @ManyToOne
    private DiscountCode discountCode;

    // getters and setters
    public Long getId() { 
        return id; 
    }

    public void setId(Long id) { 
        this.id = id; 
    }

    public Long getCustomerId() { 
        return customerId; 
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId; 
    }

    public BigDecimal getTransactionAmount() { 
        return transactionAmount; 
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount; 
    }

    public Timestamp getTransactionDate() { 
        return transactionDate; 
    }

    public void setTransactionDate(Timestamp transactionDate) { 
        this.transactionDate = transactionDate; 
    }

    public DiscountCode getDiscountCode() { 
        return discountCode; 
    }

    public void setDiscountCode(DiscountCode discountCode) { 
        this.discountCode = discountCode; 
    }
}
