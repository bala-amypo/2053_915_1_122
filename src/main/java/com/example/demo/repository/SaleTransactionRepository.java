package com.example.demo.repository;

import com.example.demo.entity.SaleTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleTransactionRepository
        extends JpaRepository<SaleTransaction, Long> {

    // REQUIRED by tests
    List<SaleTransaction> findByDiscountCode_Id(Long codeId);

    List<SaleTransaction> findByDiscountCode_Influencer_Id(Long influencerId);

    List<SaleTransaction> findByDiscountCode_Campaign_Id(Long campaignId);
}
