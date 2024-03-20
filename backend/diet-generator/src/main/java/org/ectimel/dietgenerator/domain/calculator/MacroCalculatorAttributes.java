package org.ectimel.dietgenerator.domain.calculator;

import java.math.BigDecimal;

public record MacroCalculatorAttributes(BigDecimal requiredCalories, BigDecimal bodyWeightInKg, Gender gender) {}
