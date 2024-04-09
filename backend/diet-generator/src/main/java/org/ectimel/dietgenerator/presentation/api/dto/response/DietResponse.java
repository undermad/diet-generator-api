package org.ectimel.dietgenerator.presentation.api.dto.response;

import org.ectimel.dietgenerator.presentation.api.dto.DishDto;
import org.ectimel.dietgenerator.presentation.api.dto.NutrientDto;

import java.util.List;

public record DietResponse(List<DishDto> dishes, NutrientDto nutrientDto) {
}
