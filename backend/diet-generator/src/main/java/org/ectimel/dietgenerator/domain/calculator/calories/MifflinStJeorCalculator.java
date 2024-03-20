package org.ectimel.dietgenerator.domain.calculator.calories;


import org.ectimel.dietgenerator.domain.calculator.BMRAttributes;
import org.ectimel.dietgenerator.domain.calculator.Gender;
import org.ectimel.dietgenerator.domain.calculator.bmi.BMRCalculator;
import org.ectimel.dietgenerator.domain.calculator.bmi.BaseMetabolicRate;

import java.math.BigDecimal;

public class MifflinStJeorCalculator implements BMRCalculator {


    @Override
    public BaseMetabolicRate calculate(BMRAttributes bmrAttributes) {
        if (bmrAttributes.getGender() == Gender.MALE)
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
                weightMultiplayer.multiply(bmrAttributes.getBodyWeightInKg())
                        .add(heightMultiplayer.multiply(bmrAttributes.getHeightInCm()))
                        .subtract(ageMultiplayer.multiply(bmrAttributes.getAge()))
                        .add(extra));
    }

    public BaseMetabolicRate femaleEquation(BMRAttributes bmrAttributes) {
        BigDecimal weightMultiplayer = new BigDecimal("10");
        BigDecimal heightMultiplayer = new BigDecimal("6.25");
        BigDecimal ageMultiplayer = new BigDecimal("5");
        BigDecimal extra = new BigDecimal("161");

        // BMR=(10×weight in kg)+(6.25×height in cm)−(5×age in years)−161

        return new BaseMetabolicRate(
                weightMultiplayer.multiply(bmrAttributes.getBodyWeightInKg())
                        .add(heightMultiplayer.multiply(bmrAttributes.getHeightInCm()))
                        .subtract(ageMultiplayer.multiply(bmrAttributes.getAge()))
                        .subtract(extra));
    }


}
