package org.ectimel.dietgenerator.presentation.dto.response;

import org.ectimel.dietgenerator.presentation.dto.DishDto;
import org.ectimel.dietgenerator.presentation.dto.NutrientDto;

import java.util.List;
import java.util.Map;

public record DietResponse(List<DishDto> dishes, NutrientDto nutrition, Map<String, Double> shoppingList) {
}
