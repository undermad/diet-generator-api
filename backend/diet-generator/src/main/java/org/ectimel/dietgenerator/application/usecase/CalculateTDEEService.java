package org.ectimel.dietgenerator.application.usecase;

import org.ectimel.dietgenerator.application.port.in.CalculateTDEE;
import org.ectimel.dietgenerator.domain.calculator.BMRAttributes;
import org.ectimel.dietgenerator.domain.calculator.calories.BMRCalculator;
import org.ectimel.dietgenerator.domain.calculator.calories.MifflinStJeorCalculator;

import java.math.BigDecimal;

public class CalculateTDEEService implements CalculateTDEE {

    BMRCalculator bmrCalculator;

    public CalculateTDEEService() {
        this.bmrCalculator = new MifflinStJeorCalculator();
    }


    @Override
    public BigDecimal calculateTDEE(BMRAttributes bmrAttributes) {
        return null;
    }
}
