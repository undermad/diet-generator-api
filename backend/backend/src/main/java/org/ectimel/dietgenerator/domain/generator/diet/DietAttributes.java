package org.ectimel.dietgenerator.domain.generator.diet;

import org.ectimel.dietgenerator.domain.calculator.Gender;
import org.ectimel.dietgenerator.domain.model.DietType;

import java.math.BigDecimal;

public record DietAttributes(
        BigDecimal requiredCalories,
        DietType dietType,
        BigDecimal numberOfMeals,
        BigDecimal bodyWeightInKg,
        Gender gender
) {
}
