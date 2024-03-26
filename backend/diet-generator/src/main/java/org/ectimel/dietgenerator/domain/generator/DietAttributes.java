package org.ectimel.dietgenerator.domain.generator;

import org.ectimel.dietgenerator.domain.calculator.Gender;

import java.math.BigDecimal;

public record DietAttributes(
        BigDecimal requiredCalories,
        DietType dietType,
        BigDecimal numberOfMeals,
        BigDecimal bodyWeightInKg,
        Gender gender
) {
}
