package org.ectimel.dietgenerator.application.usecase;

import org.ectimel.dietgenerator.domain.calculator.BMRAttributes;

import java.math.BigDecimal;

public interface CalculateTDEE {
    BigDecimal calculateTDEE(BMRAttributes bmrAttributes);
}
