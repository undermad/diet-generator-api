package org.ectimel.dietgenerator.domain.model.nutrient;

import org.ectimel.dietgenerator.domain.TestObjects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class NutrientsTest {

    private Nutrients baseNutrients;
    private Nutrients modifyNutrients;

    @BeforeEach
    void setUp() {
        baseNutrients = TestObjects.createTestNutrients();
        modifyNutrients = Nutrients.createEmptyNutrients();
    }

    @Test
    void addZero_shouldNotChangeValues() {
        Nutrients zeroNutrients = Nutrients.createEmptyNutrients();
        baseNutrients.addNutrients(zeroNutrients);


        assertAll("Should remain unchanged",
                () -> assertEquals(new BigDecimal("650"), baseNutrients.getCalories().getTotalCalories()),
                () -> assertEquals(new BigDecimal("20"), baseNutrients.getCarbohydrates().getTotalCarbohydrates()),
                () -> assertEquals(new BigDecimal("30"), baseNutrients.getProteins().getTotalProteins()),
                () -> assertEquals(new BigDecimal("50"), baseNutrients.getFats().getTotalFats())
        );
    }

    @Test
    void subtractZero_shouldNotChangeValues() {
        Nutrients zeroNutrients = Nutrients.createEmptyNutrients();
        baseNutrients.subtractNutrients(zeroNutrients);

        assertAll("Should remain unchanged",
                () -> assertEquals(new BigDecimal("650"), baseNutrients.getCalories().getTotalCalories()),
                () -> assertEquals(new BigDecimal("20"), baseNutrients.getCarbohydrates().getTotalCarbohydrates()),
                () -> assertEquals(new BigDecimal("30"), baseNutrients.getProteins().getTotalProteins()),
                () -> assertEquals(new BigDecimal("50"), baseNutrients.getFats().getTotalFats())
        );
    }

    @Test
    void addNegativeValues_shouldDecreaseValues() {
        modifyNutrients = new Nutrients(
                new Calories(new BigDecimal("-130")),
                new Carbohydrates(new BigDecimal("-5"), new BigDecimal("-2"), new BigDecimal("-3")),
                new Proteins(new BigDecimal("-5")),
                new Fats(new BigDecimal("-10"), new BigDecimal("-5"))
        );

        baseNutrients.addNutrients(modifyNutrients);

        assertAll("Should decrease",
                () -> assertEquals(new BigDecimal("520"), baseNutrients.getCalories().getTotalCalories()),
                () -> assertEquals(new BigDecimal("15"), baseNutrients.getCarbohydrates().getTotalCarbohydrates()),
                () -> assertEquals(new BigDecimal("25"), baseNutrients.getProteins().getTotalProteins()),
                () -> assertEquals(new BigDecimal("40"), baseNutrients.getFats().getTotalFats())
        );
    }

    @Test
    void subtractNegativeValues_shouldIncreaseValues() {
        modifyNutrients = new Nutrients(
                new Calories(new BigDecimal("-130")),
                new Carbohydrates(new BigDecimal("-5"), new BigDecimal("-2"), new BigDecimal("-3")),
                new Proteins(new BigDecimal("-5")),
                new Fats(new BigDecimal("-10"), new BigDecimal("-5"))
        );

        baseNutrients.subtractNutrients(modifyNutrients);

        assertAll("Should increase",
                () -> assertEquals(new BigDecimal("780"), baseNutrients.getCalories().getTotalCalories()),
                () -> assertEquals(new BigDecimal("25"), baseNutrients.getCarbohydrates().getTotalCarbohydrates()),
                () -> assertEquals(new BigDecimal("35"), baseNutrients.getProteins().getTotalProteins()),
                () -> assertEquals(new BigDecimal("60"), baseNutrients.getFats().getTotalFats())
        );
    }

    @Test
    void handlingNull_shouldNotThrowException() {
        assertDoesNotThrow(() -> baseNutrients.addNutrients(null));
        assertDoesNotThrow(() -> baseNutrients.subtractNutrients(null));
    }


}