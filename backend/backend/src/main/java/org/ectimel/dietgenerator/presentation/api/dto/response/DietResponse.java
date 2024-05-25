package org.ectimel.dietgenerator.presentation.api.dto.response;

import org.ectimel.dietgenerator.presentation.api.dto.DishDto;
import org.ectimel.dietgenerator.presentation.api.dto.NutrientDto;

import java.util.List;
import java.util.Map;

public record DietResponse(List<DishDto> dishes, NutrientDto nutrition, Map<String, Double> shoppingList) {
}
