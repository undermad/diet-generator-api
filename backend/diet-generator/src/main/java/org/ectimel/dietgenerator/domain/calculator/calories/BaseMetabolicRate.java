package org.ectimel.dietgenerator.domain.calculator.calories;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Getter
@AllArgsConstructor
public class BaseMetabolicRate {
    private BigDecimal baseBMR;

    public BigDecimal calculateTDEE(ActiveLevel activeLevel) {
        if(activeLevel == null) return BigDecimal.valueOf(0);
        BigDecimal multiplayer = BigDecimal.valueOf(activeLevel.getMultiplayer());
        return multiplayer.multiply(baseBMR).setScale(2, RoundingMode.HALF_DOWN);
    }
}
