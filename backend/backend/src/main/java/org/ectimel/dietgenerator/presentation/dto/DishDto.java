package org.ectimel.dietgenerator.presentation.dto;

import java.util.Map;

public record DishDto(
        Map<String, Double> productsToGrams,
        String recipeName,
        String howToCook,
        NutrientDto nutrient
) {
}
