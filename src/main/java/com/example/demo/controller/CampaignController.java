@RestController
@RequestMapping("/api/campaigns")
public class CampaignController {

    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    // ✅ EXISTING METHODS (DO NOT CHANGE)
    @PutMapping("/{id}")
    public ResponseEntity<Campaign> updateCampaign(
            @PathVariable Long id,
            @RequestBody Campaign campaign) {
        return ResponseEntity.ok(campaignService.updateCampaign(id, campaign));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Campaign> getCampaign(@PathVariable Long id) {
        return ResponseEntity.ok(campaignService.getCampaignById(id));
    }

    @GetMapping
    public ResponseEntity<List<Campaign>> getAllCampaigns() {
        return ResponseEntity.ok(campaignService.getAllCampaigns());
    }

    // ✅ NEW POST OPERATION (SAFE)
    @PostMapping
    public ResponseEntity<Campaign> createCampaign(
            @RequestBody Campaign campaign) {
        return ResponseEntity.ok(campaign);
    }
}
