package org.ectimel.dietgenerator.domain.calculator.calories;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class BaseMetabolicRate {
    private BigDecimal baseBMR;

    public BigDecimal calculateTDEE(ActiveLevel activeLevel) {
        BigDecimal multiplayer = BigDecimal.valueOf(activeLevel.getMultiplayer());
        return multiplayer.multiply(baseBMR);
    }
}
