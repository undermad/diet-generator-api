package org.ectimel.dietgenerator.domain.calculator;

import lombok.Builder;
import lombok.Getter;
import org.ectimel.dietgenerator.domain.calculator.Gender;
import org.ectimel.dietgenerator.domain.calculator.bmi.ActiveLevel;

import java.math.BigDecimal;

@Builder
@Getter
public class BMRAttributes {
    private BigDecimal bodyWeightInKg;
    private BigDecimal heightInCm;
    BigDecimal age;
    ActiveLevel activeLevel;
    Gender gender;

}
