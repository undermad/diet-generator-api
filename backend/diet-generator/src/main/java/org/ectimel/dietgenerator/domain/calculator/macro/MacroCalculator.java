package org.ectimel.dietgenerator.domain.calculator.macro;


public sealed interface MacroCalculator permits HighProteinMacroCalculator {
    Macronutrient calculate(MacroCalculatorAttributes requiredCalories);
}
