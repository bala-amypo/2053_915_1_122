package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.repository.RoiReportRepository;
import com.example.demo.repository.SaleTransactionRepository;
import com.example.demo.service.RoiService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RoiServiceImpl implements RoiService {

    private final RoiReportRepository roiReportRepository;
    private final SaleTransactionRepository saleTransactionRepository;
    private final DiscountCodeRepository discountCodeRepository;

    // ✅ CONSTRUCTOR ORDER MUST MATCH EXAM REQUIREMENT
    public RoiServiceImpl(RoiReportRepository roiReportRepository,
                          SaleTransactionRepository saleTransactionRepository,
                          DiscountCodeRepository discountCodeRepository) {
        this.roiReportRepository = roiReportRepository;
        this.saleTransactionRepository = saleTransactionRepository;
        this.discountCodeRepository = discountCodeRepository;
    }

    @Override
    public RoiReport generateRoiForCode(Long codeId) {

        // 1️⃣ Get discount code
        DiscountCode code = discountCodeRepository.findById(codeId)
                .orElseThrow(() -> new RuntimeException("Discount code not found"));

        // 2️⃣ Fetch sales linked to this code
        List<SaleTransaction> transactions =
                saleTransactionRepository.findByDiscountCode_Id(codeId);

        // 3️⃣ Calculate totals
        BigDecimal totalSales = BigDecimal.ZERO;

        for (SaleTransaction tx : transactions) {
            totalSales = totalSales.add(tx.getSaleAmount());
        }

        BigDecimal totalRevenue = totalSales;

        // 4️⃣ ROI calculation
        BigDecimal budget = code.getCampaign().getBudget();
        BigDecimal roiPercentage = BigDecimal.ZERO;

        if (budget != null && budget.compareTo(BigDecimal.ZERO) > 0) {
            roiPercentage = totalRevenue
                    .subtract(budget)
                    .divide(budget, 2, BigDecimal.ROUND_HALF_UP)
                    .multiply(BigDecimal.valueOf(100));
        }

        // 5️⃣ CREATE ROI REPORT (THIS IS WHAT YOU WERE MISSING)
        RoiReport report = new RoiReport();
        report.setCampaign(code.getCampaign());       // ✅ FIX
        report.setInfluencer(code.getInfluencer());   // ✅ FIX
        report.setTotalSales(totalSales);
        report.setTotalRevenue(totalRevenue);
        report.setRoiPercentage(roiPercentage);

        return roiReportRepository.save(report);
    }

    @Override
    public RoiReport getReportById(Long id) {
        return roiReportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ROI report not found"));
    }

    @Override
    public List<RoiReport> getReportsForInfluencer(Long influencerId) {
        return roiReportRepository.findByInfluencer_Id(influencerId);
    }

    @Override
    public List<RoiReport> getReportsForCampaign(Long campaignId) {
        return roiReportRepository.findByCampaign_Id(campaignId);
    }
}
