package org.ectimel.dietgenerator.domain.calculator.macro;


public interface MacroCalculator {
    Macronutrient calculate(MacroCalculatorAttributes requiredCalories);
}
