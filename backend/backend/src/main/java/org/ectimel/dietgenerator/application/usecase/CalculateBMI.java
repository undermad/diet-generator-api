package org.ectimel.dietgenerator.application.usecase;

import java.math.BigDecimal;

public interface CalculateBMI {
    BigDecimal calculate(BigDecimal weight, BigDecimal height);
}
