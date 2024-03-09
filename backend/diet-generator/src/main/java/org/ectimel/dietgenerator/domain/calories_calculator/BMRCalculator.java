package org.ectimel.dietgenerator.domain.calories_calculator;

public interface BMRCalculator {
    BaseMetabolicRate calculate(BMRAttributes bmrAttributes);
}
