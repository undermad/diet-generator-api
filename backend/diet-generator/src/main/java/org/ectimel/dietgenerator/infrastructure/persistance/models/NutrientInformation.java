package org.ectimel.dietgenerator.infrastructure.persistance.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NutrientInformation {
    private double totalCalories;
    private double totalCarbohydrates;
    private double fiber;
    private double sugar;
    private double totalProteins;
    private double totalFats;
    private double saturatedFats;
}
