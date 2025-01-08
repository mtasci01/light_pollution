package com.mt.light_pollution.controller;
import com.mt.light_pollution.model.ReportDTO;
import com.mt.light_pollution.model.StatsDTO;
import com.mt.light_pollution.service.LightPollutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LightPollutionController {

    private final LightPollutionService lightService;

    @PostMapping("/import_reports")
    public ResponseEntity<String> importReports(@RequestBody List<ReportDTO> reportsDto) {

        return ResponseEntity.ok(lightService.insertReports(reportsDto));

    }

    @GetMapping("/get_all_reports")
    public ResponseEntity<List<ReportDTO>> getReports() {

        return ResponseEntity.ok(lightService.getReports());

    }

    @DeleteMapping("/report")
    public ResponseEntity<String> deleteReport(@RequestParam String id) {
        lightService.deleteReport(id);
        return ResponseEntity.ok("Deleted report id " + id);

    }

    @PutMapping("/fix_report")
    public ResponseEntity<String> fixReport(@RequestParam String id) {
        lightService.fixReport(id);
        return ResponseEntity.ok("Fixed report id " + id);

    }

    @GetMapping("/get_stats")
    public ResponseEntity<StatsDTO> getStats() {
        return ResponseEntity.ok(lightService.getStats());
    }

}
