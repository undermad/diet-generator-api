package org.ectimel.dietgenerator.presentation.controller;

import org.ectimel.dietgenerator.application.usecase.CalculateBMI;
import org.ectimel.dietgenerator.application.usecase.CalculateTDEE;
import org.ectimel.dietgenerator.presentation.dto.request.BMIRequest;
import org.ectimel.dietgenerator.presentation.dto.request.TDEERequest;
import org.ectimel.dietgenerator.presentation.dto.response.BMIResponse;
import org.ectimel.dietgenerator.presentation.dto.response.TDEEResponse;
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
        return ResponseEntity.ok(new TDEEResponse(TDEE + "kcal"));
    }

    @PostMapping("/bmi")
    public ResponseEntity<BMIResponse> calculateBMI(@RequestBody BMIRequest BMIRequest) {
        Double result = calculateBMI.calculate(
                BigDecimal.valueOf(BMIRequest.bodyWeightInKg()),
                BigDecimal.valueOf(BMIRequest.heightInCm()))
                .doubleValue();

        return ResponseEntity.ok(new BMIResponse(result));
    }
}
