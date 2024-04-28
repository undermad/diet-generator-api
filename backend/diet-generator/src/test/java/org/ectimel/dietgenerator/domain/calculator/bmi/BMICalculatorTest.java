package org.ectimel.dietgenerator.domain.calculator.bmi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BMICalculatorTest {

    @Test
    void calculate_positiveValue() {
        BigDecimal result = BMICalculator.calculate(BigDecimal.valueOf(110), BigDecimal.valueOf(174));
        assertEquals(BigDecimal.valueOf(36.3), result);
    }

    @Test
    void calculate_negativeValues() {
        BigDecimal result = BMICalculator.calculate(BigDecimal.valueOf(-10), BigDecimal.valueOf(-10));
        assertEquals(BigDecimal.valueOf(0), result);
    }

    @Test
    void calculate_null() {
        BigDecimal result = BMICalculator.calculate(null, null);
        assertEquals(BigDecimal.valueOf(0), result);
    }


}