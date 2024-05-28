package org.ectimel.dietgenerator.presentation.dto;

public record NutrientDto (
        double totalCalories,
        double totalCarbohydrates,
        double fiber,
        double sugar,
        double totalProteins,
        double totalFats,
        double saturatedFats
) {
}
