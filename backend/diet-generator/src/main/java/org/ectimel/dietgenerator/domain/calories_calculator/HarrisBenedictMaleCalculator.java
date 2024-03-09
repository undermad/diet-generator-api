package org.ectimel.dietgenerator.domain.calories_calculator;


import java.math.BigDecimal;

public class HarrisBenedictMaleCalculator implements BMRCalculator {


    @Override
    public BaseMetabolicRate calculate(BMRAttributes bmrAttributes) {
        BigDecimal baseMultiplayer = new BigDecimal("88.362");
        BigDecimal weightMultiplayer = new BigDecimal("13.397");
        BigDecimal heightMultiplayer = new BigDecimal("4.799");
        BigDecimal ageMultiplayer = new BigDecimal("5.677");

        // BMR=88.362+(13.397×weight in kg)+(4.799×height in cm)−(5.677×age in years)

        return new BaseMetabolicRate(baseMultiplayer
                .add(weightMultiplayer.multiply(bmrAttributes.bodyWeightInKg))
                .add(heightMultiplayer.multiply(bmrAttributes.heightInCm))
                .subtract(ageMultiplayer.multiply(bmrAttributes.age)));
    }
}
