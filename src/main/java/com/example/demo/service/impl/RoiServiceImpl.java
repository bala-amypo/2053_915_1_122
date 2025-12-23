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

    public RoiServiceImpl(RoiReportRepository roiReportRepository,
                          SaleTransactionRepository saleTransactionRepository,
                          DiscountCodeRepository discountCodeRepository) {
        this.roiReportRepository = roiReportRepository;
        this.saleTransactionRepository = saleTransactionRepository;
        this.discountCodeRepository = discountCodeRepository;
    }

    @Override
    public RoiReport generateRoiForCode(Long codeId) {

        DiscountCode code = discountCodeRepository.findById(codeId)
                .orElseThrow(() -> new RuntimeException("Discount code not found"));

        List<SaleTransaction> transactions =
                saleTransactionRepository.findByDiscountCode_Id(codeId);

        BigDecimal totalSales = BigDecimal.ZERO;

        for (SaleTransaction tx : transactions) {
            totalSales = totalSales.add(tx.getSaleAmount());
        }

        BigDecimal totalRevenue = totalSales;

        BigDecimal budget = code.getCampaign().getBudget();
        BigDecimal roiPercentage = BigDecimal.ZERO;

        if (budget != null && budget.compareTo(BigDecimal.ZERO) > 0) {
            roiPercentage = totalRevenue
                    .subtract(budget)
                    .divide(budget, 2, BigDecimal.ROUND_HALF_UP)
                    .multiply(BigDecimal.valueOf(100));
        }

        RoiReport report = new RoiReport();
        report.setCampaign(code.getCampaign());       
        report.setInfluencer(code.getInfluencer());   
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
