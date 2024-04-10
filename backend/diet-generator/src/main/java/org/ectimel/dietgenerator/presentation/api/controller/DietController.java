package org.ectimel.dietgenerator.presentation.api.controller;

import org.ectimel.dietgenerator.presentation.api.dto.request.DietRequest;
import org.ectimel.dietgenerator.domain.model.Diet;
import org.ectimel.dietgenerator.application.port.in.CreateDiet;
import org.ectimel.dietgenerator.presentation.api.dto.response.DietResponse;
import org.ectimel.dietgenerator.presentation.api.mapper.DietMapper;
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
    public ResponseEntity<DietResponse> generateDiet(@RequestBody DietRequest dietRequest) {
        Diet diet = createDiet.createDiet(dietRequest.mapToDomain());
        return ResponseEntity.ok(dietMapper.mapToDietResponse(diet));
    }


}
