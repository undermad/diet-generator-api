package org.ectimel.dietgenerator.domain.calculator.macro;

import org.ectimel.dietgenerator.domain.calculator.Gender;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class HighProteinMacroCalculator implements MacroCalculator {


    @Override
    public Macronutrient calculate(MacroCalculatorAttributes attributes) {
        BigDecimal totalProtein = calculateTotalProtein(attributes.bodyWeightInKg(), attributes.gender());
        BigDecimal totalFats = calculateTotalFats(attributes.requiredCalories());
        BigDecimal totalCarbohydrates = calculateCarbohydrates(attributes.requiredCalories(), totalProtein, totalFats);
        return new Macronutrient(attributes.requiredCalories(), totalProtein, totalFats, totalCarbohydrates);
    }

    private BigDecimal calculateCarbohydrates(BigDecimal requiredCalories, BigDecimal totalProteins, BigDecimal totalFats) {
        BigDecimal caloriesLeft = requiredCalories.min(totalProteins.multiply(BigDecimal.valueOf(4)))
                .add(totalFats.multiply(BigDecimal.valueOf(9)));
        return caloriesLeft.divide(BigDecimal.valueOf(4), 1, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateTotalFats(BigDecimal requiredCalories) {
        BigDecimal oneThirdRequiredCalories = requiredCalories.multiply(BigDecimal.valueOf(0.3));
        return oneThirdRequiredCalories.divide(BigDecimal.valueOf(3), 1, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateTotalProtein(BigDecimal bodyWeight, Gender gender) {
        BigDecimal proteinPerBodyKg = calculateProteinPerBodyKg(gender);
        return bodyWeight.multiply(proteinPerBodyKg);
    }

    private BigDecimal calculateProteinPerBodyKg(Gender gender) {
        if (gender.equals(Gender.MALE)) return BigDecimal.valueOf(2.2);
        else return BigDecimal.valueOf(1.6);
    }


}
