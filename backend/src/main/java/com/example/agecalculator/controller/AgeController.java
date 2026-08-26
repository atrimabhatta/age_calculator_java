package com.example.agecalculator.controller;

import com.example.agecalculator.dto.AgeRequest;
import com.example.agecalculator.dto.AgeResponse;
import com.example.agecalculator.service.AgeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {
        "http://localhost:5500",
        "http://127.0.0.1:5500"
})
public class AgeController {

    private final AgeService ageService;

    public AgeController(AgeService ageService) {
        this.ageService = ageService;
    }

    @PostMapping("/calculate-age")
    public ResponseEntity<AgeResponse> calculateAge(
            @Valid @RequestBody AgeRequest request) {

        return ResponseEntity.ok(ageService.calculateAge(request));
    }
}