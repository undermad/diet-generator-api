package org.ectimel.dietgenerator.domain.calculator.calories;

import org.ectimel.dietgenerator.domain.calculator.BMRAttributes;
import org.ectimel.dietgenerator.domain.calculator.Gender;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MifflinStJeorCalculatorTest {


    BMRCalculator bmrCalculator;

    @BeforeEach
    void setup(){
        bmrCalculator = new MifflinStJeorCalculator();
    }


    @Test
    void calculate_male() {
        BMRAttributes attributes = BMRAttributes.builder()
                .bodyWeightInKg(BigDecimal.valueOf(110))
                .heightInCm(BigDecimal.valueOf(174))
                .age(BigDecimal.valueOf(30))
                .gender(Gender.MALE)
                .build();

         BaseMetabolicRate baseMetabolicRate = bmrCalculator.calculate(attributes);
         assertEquals(new BigDecimal("2042.50"), baseMetabolicRate.getBaseBMR());
    }

    @Test
    void calculate_female() {
        BMRAttributes attributes = BMRAttributes.builder()
                .bodyWeightInKg(BigDecimal.valueOf(60))
                .heightInCm(BigDecimal.valueOf(164))
                .age(BigDecimal.valueOf(30))
                .gender(Gender.FEMALE)
                .build();

        BaseMetabolicRate baseMetabolicRate = bmrCalculator.calculate(attributes);
        assertEquals(new BigDecimal("1314.00"), baseMetabolicRate.getBaseBMR());
    }

    @Test
    void calculate_null() {
        BaseMetabolicRate baseMetabolicRate = bmrCalculator.calculate(null);
        assertEquals(new BigDecimal("0"), baseMetabolicRate.getBaseBMR());
    }
}