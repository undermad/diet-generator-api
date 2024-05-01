package org.ectimel.dietgenerator.presentation.api.controller;

import org.ectimel.dietgenerator.application.port.in.CalculateTDEE;
import org.ectimel.dietgenerator.presentation.api.dto.request.TDEERequest;
import org.ectimel.dietgenerator.presentation.api.dto.response.TDEEResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController {

    private final CalculateTDEE calculateTDEE;

    public CalculatorController(CalculateTDEE calculateTDEE) {
        this.calculateTDEE = calculateTDEE;
    }


    @PostMapping
    public ResponseEntity<TDEEResponse> calculateTDEE(@RequestBody TDEERequest TDEERequest) {

        return null;
    }
}
