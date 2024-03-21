package org.ectimel.dietgenerator.domain.calculator.macro;

import org.ectimel.dietgenerator.domain.calculator.Gender;

import java.math.BigDecimal;

public record MacroCalculatorAttributes(BigDecimal requiredCalories, BigDecimal bodyWeightInKg, Gender gender) {}
