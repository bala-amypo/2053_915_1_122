@Service
public class RoiServiceImpl implements RoiService {

    private final RoiReportRepository roiReportRepository;
    private final DiscountCodeRepository discountCodeRepository;

    public RoiServiceImpl(
            RoiReportRepository roiReportRepository,
            DiscountCodeRepository discountCodeRepository) {
        this.roiReportRepository = roiReportRepository;
        this.discountCodeRepository = discountCodeRepository;
    }

    @Override
    public RoiReport createReport(RoiReport report) {
        report.setDiscountCode(
                discountCodeRepository.findById(report.getDiscountCode().getId())
                        .orElseThrow(() -> new RuntimeException("Discount code not found"))
        );
        return roiReportRepository.save(report);
    }

    @Override
    public List<RoiReport> getReportsForInfluencer(Long influencerId) {
        return roiReportRepository.findByDiscountCode_Influencer_Id(influencerId);
    }
}
