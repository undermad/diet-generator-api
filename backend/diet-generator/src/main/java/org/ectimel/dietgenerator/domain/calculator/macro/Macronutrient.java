package org.ectimel.dietgenerator.domain.calculator.macro;

import java.math.BigDecimal;

public record Macronutrient(BigDecimal calories, BigDecimal proteins, BigDecimal fats, BigDecimal carbohydrates) { }
