package org.ectimel.dietgenerator.domain.calories_calculator;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class BMRAttributes {
    BigDecimal bodyWeightInKg;
    BigDecimal heightInCm;
    BigDecimal age;
    ActiveLevel activeLevel;
    Gender gender;

}
