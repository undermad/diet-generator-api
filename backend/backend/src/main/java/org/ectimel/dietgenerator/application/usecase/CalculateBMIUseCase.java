package org.ectimel.dietgenerator.application.usecase;

import org.ectimel.dietgenerator.domain.calculator.bmi.BMICalculator;

import java.math.BigDecimal;

public class CalculateBMIUseCase implements CalculateBMI {


    @Override
    public BigDecimal calculate(BigDecimal weight, BigDecimal height) {
        return BMICalculator.calculate(weight, height);
    }
}
