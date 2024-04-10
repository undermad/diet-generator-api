package org.ectimel.dietgenerator.domain.calculator.calories;

import lombok.Getter;

@Getter
public enum ActiveLevel {
    SEDENTARY(1.2),
    LIGHTLY_ACTIVE(1.375),
    MODERATELY_ACTIVE(1.55),
    VERY_ACTIVE(1.725),
    SUPER_ACTIVE(1.9);

    private final double multiplayer;

    ActiveLevel(double value) {
        this.multiplayer = value;
    }
}
