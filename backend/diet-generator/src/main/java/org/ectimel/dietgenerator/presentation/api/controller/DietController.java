package org.ectimel.dietgenerator.presentation.api.controller;

import org.ectimel.dietgenerator.presentation.api.dto.request.DietRequest;
import org.ectimel.dietgenerator.domain.model.Diet;
import org.ectimel.dietgenerator.application.port.in.DietService;
import org.ectimel.dietgenerator.presentation.api.dto.response.DietResponse;
import org.ectimel.dietgenerator.presentation.api.mapper.DietMapper;
import org.ectimel.dietgenerator.presentation.api.mapper.DishMapper;
import org.ectimel.dietgenerator.presentation.api.mapper.NutrientDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/diet")
public class DietController {

    private final DietService dietService;
    private final DietMapper dietMapper;

    public DietController(DietService dietService, DietMapper dietMapper) {
        this.dietService = dietService;
        this.dietMapper = dietMapper;
    }

    @PostMapping
    public ResponseEntity<DietResponse> generateDiet(@RequestBody DietRequest dietRequest) {
        Diet diet = dietService.generateDiet(dietRequest.mapToDomain());
        return ResponseEntity.ok(dietMapper.mapToDietResponse(diet));
    }


}
