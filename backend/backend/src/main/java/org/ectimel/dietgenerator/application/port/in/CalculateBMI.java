package org.ectimel.dietgenerator.application.port.in;

import java.math.BigDecimal;

public interface CalculateBMI {
    BigDecimal calculate(BigDecimal weight, BigDecimal height);
}
