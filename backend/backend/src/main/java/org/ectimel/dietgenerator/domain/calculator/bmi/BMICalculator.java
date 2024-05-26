package org.ectimel.dietgenerator.domain.calculator.bmi;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public interface BMICalculator {

    static BigDecimal calculate(BigDecimal bodyWeightInKg, BigDecimal heightInCm) {
        if(bodyWeightInKg == null || bodyWeightInKg.doubleValue() <= 0 || heightInCm == null || heightInCm.doubleValue() <= 0)
            return BigDecimal.valueOf(0);

        BigDecimal heightInMeters = heightInCm.divide(new BigDecimal("100"), new MathContext(3, RoundingMode.HALF_DOWN));
        BigDecimal heightSquared = heightInMeters.multiply(heightInMeters, new MathContext(3, RoundingMode.HALF_DOWN));
        return bodyWeightInKg.divide(heightSquared, new MathContext(3, RoundingMode.HALF_UP));
    }
}


