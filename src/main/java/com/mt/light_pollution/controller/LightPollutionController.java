package com.mt.light_pollution.controller;
import com.mt.light_pollution.model.ReportDTO;
import com.mt.light_pollution.service.LightPollutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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



}
