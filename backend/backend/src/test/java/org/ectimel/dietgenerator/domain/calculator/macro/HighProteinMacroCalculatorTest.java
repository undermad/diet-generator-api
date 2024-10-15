package org.ectimel.dietgenerator.domain.calculator.macro;

import org.ectimel.dietgenerator.domain.calculator.Gender;
import org.ectimel.dietgenerator.domain.model.DietType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HighProteinMacroCalculatorTest {

    private MacroCalculator macroCalculator;

    @BeforeEach
    void setUp() {
        macroCalculator = MacroCalculatorFactory.getMacroCalculator(DietType.PROTEIN);


    }

    @Test
    void calculate_male() {
        MacroCalculatorAttributes macroCalculatorAttributes = new MacroCalculatorAttributes(
                BigDecimal.valueOf(2500), BigDecimal.valueOf(100), Gender.MALE);
        Macronutrient macronutrient = macroCalculator.calculate(macroCalculatorAttributes);

        assertAll("Need to be correct!",
                () -> assertEquals(BigDecimal.valueOf(2500), macronutrient.getCalories()),
                () -> assertEquals(BigDecimal.valueOf(220.0), macronutrient.getProteins()),
                () -> assertEquals(BigDecimal.valueOf(217.6), macronutrient.getCarbohydrates()),
                () -> assertEquals(BigDecimal.valueOf(83.3), macronutrient.getFats()));
    }

    @Test
    void calculate_female() {
        MacroCalculatorAttributes macroCalculatorAttributes = new MacroCalculatorAttributes(
                BigDecimal.valueOf(2000), BigDecimal.valueOf(60), Gender.FEMALE);
        Macronutrient macronutrient = macroCalculator.calculate(macroCalculatorAttributes);

        assertAll("Need to be correct!",
                () -> assertEquals(BigDecimal.valueOf(2000), macronutrient.getCalories()),
                () -> assertEquals(BigDecimal.valueOf(96.0), macronutrient.getProteins()),
                () -> assertEquals(BigDecimal.valueOf(253.9), macronutrient.getCarbohydrates()),
                () -> assertEquals(BigDecimal.valueOf(66.7), macronutrient.getFats()));
    }

    @Test
    void calculate_null() {
        MacroCalculatorAttributes macroCalculatorAttributes1 = new MacroCalculatorAttributes(
                BigDecimal.valueOf(2000), BigDecimal.valueOf(60), null);
        MacroCalculatorAttributes macroCalculatorAttributes2 = new MacroCalculatorAttributes(
                BigDecimal.valueOf(2000), null, Gender.MALE);
        MacroCalculatorAttributes macroCalculatorAttributes3 = new MacroCalculatorAttributes(
                null, BigDecimal.valueOf(60), Gender.MALE);

        Macronutrient macronutrient1 = macroCalculator.calculate(macroCalculatorAttributes1);
        Macronutrient macronutrient2 = macroCalculator.calculate(macroCalculatorAttributes2);
        Macronutrient macronutrient3 = macroCalculator.calculate(macroCalculatorAttributes3);
        Macronutrient macronutrient4 = macroCalculator.calculate(null);

        assertAll("Need to be 0",
                () -> assertEquals(BigDecimal.valueOf(0), macronutrient1.getCalories()),
                () -> assertEquals(BigDecimal.valueOf(0), macronutrient1.getProteins()),
                () -> assertEquals(BigDecimal.valueOf(0), macronutrient1.getCarbohydrates()),
                () -> assertEquals(BigDecimal.valueOf(0), macronutrient1.getFats()));

        assertAll("Need to be 0",
                () -> assertEquals(BigDecimal.valueOf(0), macronutrient2.getCalories()),
                () -> assertEquals(BigDecimal.valueOf(0), macronutrient2.getProteins()),
                () -> assertEquals(BigDecimal.valueOf(0), macronutrient2.getCarbohydrates()),
                () -> assertEquals(BigDecimal.valueOf(0), macronutrient2.getFats()));

        assertAll("Need to be 0",
                () -> assertEquals(BigDecimal.valueOf(0), macronutrient3.getCalories()),
                () -> assertEquals(BigDecimal.valueOf(0), macronutrient3.getProteins()),
                () -> assertEquals(BigDecimal.valueOf(0), macronutrient3.getCarbohydrates()),
                () -> assertEquals(BigDecimal.valueOf(0), macronutrient3.getFats()));

        assertAll("Need to be 0",
                () -> assertEquals(BigDecimal.valueOf(0), macronutrient4.getCalories()),
                () -> assertEquals(BigDecimal.valueOf(0), macronutrient4.getProteins()),
                () -> assertEquals(BigDecimal.valueOf(0), macronutrient4.getCarbohydrates()),
                () -> assertEquals(BigDecimal.valueOf(0), macronutrient4.getFats()));


    }
}