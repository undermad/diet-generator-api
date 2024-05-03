package org.ectimel.dietgenerator.presentation.api.controller;

import org.ectimel.dietgenerator.application.port.in.CalculateBMI;
import org.ectimel.dietgenerator.application.port.in.CalculateTDEE;
import org.ectimel.dietgenerator.presentation.api.dto.request.BMIRequest;
import org.ectimel.dietgenerator.presentation.api.dto.request.TDEERequest;
import org.ectimel.dietgenerator.presentation.api.dto.response.BMIResponse;
import org.ectimel.dietgenerator.presentation.api.dto.response.TDEEResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController {

    private final CalculateTDEE TDEECalculator;
    private final CalculateBMI calculateBMI;

    public CalculatorController(CalculateTDEE TDEECalculator, CalculateBMI calculateBMI) {
        this.TDEECalculator = TDEECalculator;
        this.calculateBMI = calculateBMI;
    }


    @PostMapping("/tdee")
    public ResponseEntity<TDEEResponse> calculateTDEE(@RequestBody TDEERequest TDEERequest) {
        Double TDEE = TDEECalculator.calculateTDEE(TDEERequest.mapToDomain()).doubleValue();
        return ResponseEntity.ok(new TDEEResponse(TDEE));
    }

    @PostMapping("/bmi")
    public ResponseEntity<BMIResponse> calculateBMI(@RequestBody BMIRequest BMIRequest) {
        Double result = calculateBMI.calculate(
                BigDecimal.valueOf(BMIRequest.weight()),
                BigDecimal.valueOf(BMIRequest.height()))
                .doubleValue();

        return ResponseEntity.ok(new BMIResponse(result));
    }
}
