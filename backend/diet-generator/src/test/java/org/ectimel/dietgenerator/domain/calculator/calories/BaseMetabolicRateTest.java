package org.ectimel.dietgenerator.domain.calculator.calories;

import org.ectimel.dietgenerator.domain.calculator.BMRAttributes;
import org.ectimel.dietgenerator.domain.calculator.Gender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BaseMetabolicRateTest {

    BMRCalculator bmrCalculator;
        BMRAttributes attributes;

    @BeforeEach
    void setup() {
        bmrCalculator = new MifflinStJeorCalculator();
        attributes = BMRAttributes.builder()
                .bodyWeightInKg(BigDecimal.valueOf(110))
                .heightInCm(BigDecimal.valueOf(174))
                .age(BigDecimal.valueOf(30))
                .gender(Gender.MALE)
                .build();
    }

    @Test
    void calculateTDEE_null() {
        BigDecimal TDEE = bmrCalculator.calculate(attributes).calculateTDEE(null);
        assertEquals(new BigDecimal("0"), TDEE);
    }

    @Test
    void calculateTDEE_SEDNTARY() {
        BigDecimal TDEE = bmrCalculator.calculate(attributes).calculateTDEE(ActiveLevel.SEDENTARY);
        assertEquals(new BigDecimal("2451.00"), TDEE);
    }

    @Test
    void calculateTDEE_LIGHTLY_ACTIVE() {
        BigDecimal TDEE = bmrCalculator.calculate(attributes).calculateTDEE(ActiveLevel.LIGHTLY_ACTIVE);
        assertEquals(new BigDecimal("2808.44"), TDEE);
    }

    @Test
    void calculateTDEE_MODERATELY_ACTIVE() {
        BigDecimal TDEE = bmrCalculator.calculate(attributes).calculateTDEE(ActiveLevel.MODERATELY_ACTIVE);
        assertEquals(new BigDecimal("3165.87"), TDEE);
    }

    @Test
    void calculateTDEE_VERY_ACTIVE() {
        BigDecimal TDEE = bmrCalculator.calculate(attributes).calculateTDEE(ActiveLevel.VERY_ACTIVE);
        assertEquals(new BigDecimal("3523.31"), TDEE);
    }

    @Test
    void calculateTDEE_SUPER_ACTIVE() {
        BigDecimal TDEE = bmrCalculator.calculate(attributes).calculateTDEE(ActiveLevel.SUPER_ACTIVE);
        assertEquals(new BigDecimal("3880.75"), TDEE);
    }
}