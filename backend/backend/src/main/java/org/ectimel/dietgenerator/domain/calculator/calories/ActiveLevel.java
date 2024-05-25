package org.ectimel.dietgenerator.domain.calculator.calories;

import lombok.Getter;
import org.ectimel.dietgenerator.domain.exception.WrongInputException;

@Getter
public enum ActiveLevel {
    SEDENTARY(1.2),
    LIGHTLY(1.375),
    MODERATELY(1.55),
    VERY(1.725),
    SUPER(1.9);

    private final double multiplayer;

    ActiveLevel(double value) {
        this.multiplayer = value;
    }

    public static ActiveLevel fromString(String text) {
        if (text != null) {
            for (ActiveLevel level : ActiveLevel.values()) {
                if (text.equalsIgnoreCase(level.name())) {
                    return level;
                }
            }
        }
        throw new WrongInputException("Choose correct active level -> SEDENTARY, LIGHTLY, MODERATELY, VERY, SUPER");
    }
}
