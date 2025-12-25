package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
public class SaleTransaction {

    @Id
    @GeneratedValue
    private Long id;

    private BigDecimal transactionAmount;
    private long customerId;

    private Timestamp transactionDate;

    @ManyToOne
    private DiscountCode discountCode;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }
    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public long getCustomerId() { return customerId; }
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public Timestamp getTransactionDate() { return transactionDate; }
    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    public DiscountCode getDiscountCode() { return discountCode; }
    public void setDiscountCode(DiscountCode discountCode) {
        this.discountCode = discountCode;
    }
}
