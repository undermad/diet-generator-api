package org.ectimel.dietgenerator.domain.calculator.bmi;

import org.ectimel.dietgenerator.domain.calculator.BMRAttributes;

public interface BMRCalculator {
    BaseMetabolicRate calculate(BMRAttributes bmrAttributes);
}
