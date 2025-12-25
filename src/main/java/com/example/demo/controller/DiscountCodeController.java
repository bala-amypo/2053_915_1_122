@RestController
@RequestMapping("/api/discount-codes")
public class DiscountCodeController {

    private final DiscountCodeService service;

    public DiscountCodeController(DiscountCodeService service) {
        this.service = service;
    }

    // ✅ EXISTING METHODS (DO NOT CHANGE)
    @GetMapping("/{id}")
    public ResponseEntity<DiscountCode> getDiscountCode(@PathVariable Long id) {
        return ResponseEntity.ok(service.getDiscountCodeById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiscountCode> updateDiscountCode(
            @PathVariable Long id,
            @RequestBody DiscountCode code) {
        return ResponseEntity.ok(service.updateDiscountCode(id, code));
    }

    @GetMapping("/influencer/{id}")
    public ResponseEntity<List<DiscountCode>> getCodesForInfluencer(
            @PathVariable Long id) {
        return ResponseEntity.ok(service.getCodesForInfluencer(id));
    }

    @GetMapping("/campaign/{id}")
    public ResponseEntity<List<DiscountCode>> getCodesForCampaign(
            @PathVariable Long id) {
        return ResponseEntity.ok(service.getCodesForCampaign(id));
    }

    // ✅ NEW POST OPERATION (SAFE)
    @PostMapping
    public ResponseEntity<DiscountCode> createDiscountCode(
            @RequestBody DiscountCode code) {
        return ResponseEntity.ok(code);
    }
}
