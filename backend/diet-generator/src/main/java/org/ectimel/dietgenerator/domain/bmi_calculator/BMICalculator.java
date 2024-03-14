package org.ectimel.dietgenerator.domain.bmi_calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BMICalculator {

    public BigDecimal calculate(BigDecimal bodyWeightInKg, BigDecimal heightInCm) {
        BigDecimal heightInMeters = heightInCm.divide(new BigDecimal("100"), new MathContext(3, RoundingMode.HALF_DOWN));
        BigDecimal heightCubed = heightInMeters.multiply(heightInMeters, new MathContext(3, RoundingMode.HALF_DOWN));
        return bodyWeightInKg.divide(heightCubed, new MathContext(3, RoundingMode.HALF_UP));
    }
}
