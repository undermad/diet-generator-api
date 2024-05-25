package org.ectimel.dietgenerator.presentation.api.dto;

import java.util.Map;

public record DishDto(
        Map<String, Double> productsToGrams,
        String recipeName,
        String howToCook,
        NutrientDto nutrient
) {
}
