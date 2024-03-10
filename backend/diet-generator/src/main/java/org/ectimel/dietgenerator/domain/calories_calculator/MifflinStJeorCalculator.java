package org.ectimel.dietgenerator.domain.calories_calculator;


import java.math.BigDecimal;

public class MifflinStJeorCalculator implements BMRCalculator {


    @Override
    public BaseMetabolicRate calculate(BMRAttributes bmrAttributes) {
        if (bmrAttributes.gender == Gender.MALE)
            return maleEquation(bmrAttributes);
        else return femaleEquation(bmrAttributes);
    }

    private BaseMetabolicRate maleEquation(BMRAttributes bmrAttributes) {

        BigDecimal weightMultiplayer = new BigDecimal("10");
        BigDecimal heightMultiplayer = new BigDecimal("6.25");
        BigDecimal ageMultiplayer = new BigDecimal("5");
        BigDecimal extra = new BigDecimal("5");

        // BMR=(10×weight in kg)+(6.25×height in cm)−(5×age in years)+5

        return new BaseMetabolicRate(
                weightMultiplayer.multiply(bmrAttributes.bodyWeightInKg)
                        .add(heightMultiplayer.multiply(bmrAttributes.heightInCm))
                        .subtract(ageMultiplayer.multiply(bmrAttributes.age))
                        .add(extra));
    }

    public BaseMetabolicRate femaleEquation(BMRAttributes bmrAttributes) {
        BigDecimal weightMultiplayer = new BigDecimal("10");
        BigDecimal heightMultiplayer = new BigDecimal("6.25");
        BigDecimal ageMultiplayer = new BigDecimal("5");
        BigDecimal extra = new BigDecimal("161");

        // BMR=(10×weight in kg)+(6.25×height in cm)−(5×age in years)−161

        return new BaseMetabolicRate(
                weightMultiplayer.multiply(bmrAttributes.bodyWeightInKg)
                        .add(heightMultiplayer.multiply(bmrAttributes.heightInCm))
                        .subtract(ageMultiplayer.multiply(bmrAttributes.age))
                        .subtract(extra));
    }


}
