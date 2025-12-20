@RestController
@RequestMapping("/roi")
public class RoiReportController {

    private final RoiService service;

    public RoiReportController(RoiService service) {
        this.service = service;
    }
}
