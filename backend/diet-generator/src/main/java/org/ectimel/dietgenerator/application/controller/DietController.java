package org.ectimel.dietgenerator.application.controller;

import org.ectimel.dietgenerator.application.dto.DietRequest;
import org.ectimel.dietgenerator.domain.generator.DietType;
import org.ectimel.dietgenerator.domain.port.in.DietService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/diet")
public class DietController {

    private final DietService dietService;

    public DietController(DietService dietService) {
        this.dietService = dietService;
    }

    @PostMapping
    public ResponseEntity<String> generateDiet(@RequestBody DietRequest dietRequest) {
        dietService.generateDiet(dietRequest.mapToDomain())
                .onSuccess(diet -> {

                }).onFailure(error -> {

                });
        return ResponseEntity.ok("Ok");
    }


}
