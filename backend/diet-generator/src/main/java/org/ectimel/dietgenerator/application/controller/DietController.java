package org.ectimel.dietgenerator.application.controller;

import org.ectimel.dietgenerator.application.dto.DietRequest;
import org.ectimel.dietgenerator.domain.model.Diet;
import org.ectimel.dietgenerator.domain.port.in.DietService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/diet")
public class DietController {

    private final DietService dietService;

    public DietController(DietService dietService) {
        this.dietService = dietService;
    }

    @PostMapping
    public ResponseEntity<Diet> generateDiet(@RequestBody DietRequest dietRequest) {
        Diet diet = dietService.generateDiet(dietRequest.mapToDomain());

        return ResponseEntity.ok(diet);
    }


}
