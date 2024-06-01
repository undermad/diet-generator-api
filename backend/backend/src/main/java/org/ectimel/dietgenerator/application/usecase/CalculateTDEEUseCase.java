package org.ectimel.dietgenerator.application.usecase;

import org.ectimel.dietgenerator.domain.calculator.BMRAttributes;
import org.ectimel.dietgenerator.domain.calculator.calories.BMRCalculator;
import org.ectimel.dietgenerator.domain.calculator.calories.MifflinStJeorCalculator;

import java.math.BigDecimal;

public class CalculateTDEEUseCase implements CalculateTDEE {

    BMRCalculator bmrCalculator;

    public CalculateTDEEUseCase() {
        this.bmrCalculator = new MifflinStJeorCalculator();
    }


    @Override
    public BigDecimal calculateTDEE(BMRAttributes bmrAttributes) {
        return bmrCalculator.calculate(bmrAttributes).calculateTDEE(bmrAttributes.getActiveLevel());
    }
}
