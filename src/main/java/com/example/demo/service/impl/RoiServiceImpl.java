package com.example.demo.service.impl;

import com.example.demo.entity.DiscountCode;
import com.example.demo.entity.RoiReport;
import com.example.demo.entity.SaleTransaction;
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

    public RoiServiceImpl(
            RoiReportRepository roiReportRepository,
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

        List<SaleTransaction> sales =
                saleTransactionRepository.findByDiscountCode_Id(codeId);

        BigDecimal totalSales = sales.stream()
                .map(SaleTransaction::getSaleAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        RoiReport report = new RoiReport();
        report.setTotalSales(totalSales);
        report.setTotalRevenue(totalSales);
        report.setRoiPercentage(BigDecimal.ZERO);

        return roiReportRepository.save(report);
    }

    @Override
    public RoiReport getReportById(Long id) {
        return roiReportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found"));
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
