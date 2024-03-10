package org.ectimel.dietgenerator.domain.calories_calculator;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class BaseMetabolicRate {
    private BigDecimal baseBMR;

    public BigDecimal calculateTDEE(ActiveLevel activeLevel) {
        BigDecimal multiplayer = BigDecimal.valueOf(activeLevel.getMultiplayer());
        return multiplayer.multiply(baseBMR);
    }
}
