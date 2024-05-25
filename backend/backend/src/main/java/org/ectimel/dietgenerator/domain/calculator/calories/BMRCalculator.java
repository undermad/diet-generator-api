package org.ectimel.dietgenerator.domain.calculator.calories;

import org.ectimel.dietgenerator.domain.calculator.BMRAttributes;

public interface BMRCalculator {
    BaseMetabolicRate calculate(BMRAttributes bmrAttributes);
}
