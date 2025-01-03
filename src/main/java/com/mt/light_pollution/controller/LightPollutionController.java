package com.mt.light_pollution.controller;
import com.mt.light_pollution.service.LightPollutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LightPollutionController {

    private final LightPollutionService lightService;

    public LightPollutionController(LightPollutionService lightService) {
        this.lightService = lightService;
    }

    @GetMapping("/ggggg")
    public ResponseEntity overlappingAccess(@RequestBody List<Long[]> accessList) {

        return ResponseEntity.ok(lightService.run());

    }

}
