package org.ectimel.dietgenerator.domain.calculator.macro;

import org.ectimel.dietgenerator.domain.calculator.MacroCalculatorAttributes;


public interface MacroCalculator {
    Macronutrient calculate(MacroCalculatorAttributes requiredCalories);
}
