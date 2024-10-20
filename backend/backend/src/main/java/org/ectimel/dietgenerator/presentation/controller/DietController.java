package org.ectimel.dietgenerator.presentation.controller;

import jakarta.validation.Valid;
import org.ectimel.dietgenerator.presentation.dto.request.DietRequest;
import org.ectimel.dietgenerator.domain.model.Diet;
import org.ectimel.dietgenerator.application.usecase.CreateDiet;
import org.ectimel.dietgenerator.presentation.dto.response.DietResponse;
import org.ectimel.dietgenerator.presentation.mapper.DietMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/diet")
public class DietController {

    private final CreateDiet createDiet;
    private final DietMapper dietMapper;

    public DietController(CreateDiet createDiet, DietMapper dietMapper) {
        this.createDiet = createDiet;
        this.dietMapper = dietMapper;
    }

    @PostMapping
    public ResponseEntity<DietResponse> generateDiet(@Valid @RequestBody DietRequest dietRequest) {
        Diet diet = createDiet.createDiet(dietRequest.mapToDomain());
        return ResponseEntity.ok(dietMapper.mapToDietResponse(diet));
    }


}
