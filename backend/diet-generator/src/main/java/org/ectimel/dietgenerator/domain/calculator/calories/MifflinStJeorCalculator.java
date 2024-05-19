package org.ectimel.dietgenerator.domain.calculator.calories;


import org.ectimel.dietgenerator.domain.calculator.BMRAttributes;
import org.ectimel.dietgenerator.domain.calculator.Gender;

import java.math.BigDecimal;

public class MifflinStJeorCalculator implements BMRCalculator {


    @Override
    public BaseMetabolicRate calculate(BMRAttributes bmrAttributes) {
        if(bmrAttributes == null) return new BaseMetabolicRate(BigDecimal.valueOf(0));
        if (bmrAttributes.getGender() == Gender.MALE)
            return calculateUsingMaleEquation(bmrAttributes);
        else return calculateUsingFemaleEquation(bmrAttributes);
    }

    private BaseMetabolicRate calculateUsingMaleEquation(BMRAttributes bmrAttributes) {

        BigDecimal weightMultiplayer = new BigDecimal("10");
        BigDecimal heightMultiplayer = new BigDecimal("6.25");
        BigDecimal ageMultiplayer = new BigDecimal("5");
        BigDecimal extra = new BigDecimal("5");

        // BMR=(10×bodyWeightInKg in kg)+(6.25×heightInCm in cm)−(5×age in years)+5

        return new BaseMetabolicRate(
                weightMultiplayer.multiply(bmrAttributes.getBodyWeightInKg())
                        .add(heightMultiplayer.multiply(bmrAttributes.getHeightInCm()))
                        .subtract(ageMultiplayer.multiply(bmrAttributes.getAge()))
                        .add(extra));
    }

    private BaseMetabolicRate calculateUsingFemaleEquation(BMRAttributes bmrAttributes) {
        BigDecimal weightMultiplayer = new BigDecimal("10");
        BigDecimal heightMultiplayer = new BigDecimal("6.25");
        BigDecimal ageMultiplayer = new BigDecimal("5");
        BigDecimal extra = new BigDecimal("161");

        // BMR=(10×bodyWeightInKg in kg)+(6.25×heightInCm in cm)−(5×age in years)−161

        return new BaseMetabolicRate(
                weightMultiplayer.multiply(bmrAttributes.getBodyWeightInKg())
                        .add(heightMultiplayer.multiply(bmrAttributes.getHeightInCm()))
                        .subtract(ageMultiplayer.multiply(bmrAttributes.getAge()))
                        .subtract(extra));
    }


}
