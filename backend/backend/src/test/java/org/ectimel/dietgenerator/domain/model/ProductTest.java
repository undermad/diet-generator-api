package org.ectimel.dietgenerator.domain.model;

import org.ectimel.dietgenerator.domain.model.nutrient.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Product product;

    @BeforeEach
    void setUp() {
        Nutrients nutrients = new Nutrients(
                new Calories(BigDecimal.valueOf(170)),
                new Carbohydrates(BigDecimal.valueOf(10),
                        BigDecimal.valueOf(1),
                        BigDecimal.valueOf(1)),
                new Proteins(BigDecimal.valueOf(10)),
                new Fats(BigDecimal.valueOf(10),
                        BigDecimal.valueOf(2)));

        product = new Product(null, "Test Product", nutrients, Filler.FAT);

    }

    @Test
    void calculateNutrients_positiveValue() {
        Nutrients result = product.calculateNutrients(BigDecimal.valueOf(200));
        assertAll("Should double the values",
                () -> assertEquals(new BigDecimal("340"), result.getCalories().getTotalCalories()),
                () -> assertEquals(new BigDecimal("20"), result.getCarbohydrates().getTotalCarbohydrates()),
                () -> assertEquals(new BigDecimal("20"), result.getProteins().getTotalProteins()),
                () -> assertEquals(new BigDecimal("20"), result.getFats().getTotalFats()));
    }

    @Test
    void calculateNutrients_negativeValues() {
        Nutrients result = product.calculateNutrients(BigDecimal.valueOf(-100));
        assertAll("Should return empty nutrients",
                () -> assertEquals(new BigDecimal("0"), result.getCalories().getTotalCalories()),
                () -> assertEquals(new BigDecimal("0"), result.getCarbohydrates().getTotalCarbohydrates()),
                () -> assertEquals(new BigDecimal("0"), result.getProteins().getTotalProteins()),
                () -> assertEquals(new BigDecimal("0"), result.getFats().getTotalFats()));
    }

    @Test
    void calculateNutrients_nullValue() {
        Nutrients result = product.calculateNutrients(null);
        assertAll("Should return empty nutrients",
                () -> assertEquals(new BigDecimal("0"), result.getCalories().getTotalCalories()),
                () -> assertEquals(new BigDecimal("0"), result.getCarbohydrates().getTotalCarbohydrates()),
                () -> assertEquals(new BigDecimal("0"), result.getProteins().getTotalProteins()),
                () -> assertEquals(new BigDecimal("0"), result.getFats().getTotalFats()));
    }

    @Test
    void calculateNutrients_zeroValue() {
        Nutrients result = product.calculateNutrients(BigDecimal.valueOf(0));
        assertAll("Should return empty nutrients",
                () -> assertEquals(new BigDecimal("0"), result.getCalories().getTotalCalories()),
                () -> assertEquals(new BigDecimal("0"), result.getCarbohydrates().getTotalCarbohydrates()),
                () -> assertEquals(new BigDecimal("0"), result.getProteins().getTotalProteins()),
                () -> assertEquals(new BigDecimal("0"), result.getFats().getTotalFats()));
    }

    @Test
    void calculateProductGramsForRequiredFiller_positiveValues() {
        BigDecimal resultNone = product.calculateProductGramsForRequiredFiller(Filler.NONE, BigDecimal.valueOf(1));
        BigDecimal resultFat = product.calculateProductGramsForRequiredFiller(Filler.FAT, BigDecimal.valueOf(1));
        BigDecimal resultProteins = product.calculateProductGramsForRequiredFiller(Filler.PROTEIN, BigDecimal.valueOf(1));
        BigDecimal resultCarbohydrates = product.calculateProductGramsForRequiredFiller(Filler.CARBOHYDRATE, BigDecimal.valueOf(1));

        assertAll("Should return 0",
                () -> assertEquals(BigDecimal.valueOf(0), resultNone),
                () -> assertEquals(BigDecimal.valueOf(10), resultFat),
                () -> assertEquals(BigDecimal.valueOf(10), resultProteins),
                () -> assertEquals(BigDecimal.valueOf(10), resultCarbohydrates));
    }

    @Test
    void calculateProductGramsForRequiredFiller_negativeValue() {
        BigDecimal result = product.calculateProductGramsForRequiredFiller(Filler.CARBOHYDRATE, BigDecimal.valueOf(-999));
        assertEquals(BigDecimal.valueOf(0), result);
    }

    @Test
    void calculateProductGramsForRequiredFiller_nullFirstParam() {
        BigDecimal result = product.calculateProductGramsForRequiredFiller(null, BigDecimal.valueOf(123));
        assertEquals(BigDecimal.valueOf(0), result);
    }

    @Test
    void calculateProductGramsForRequiredFiller_nullSecondParam() {
        BigDecimal result = product.calculateProductGramsForRequiredFiller(Filler.CARBOHYDRATE, null);
        assertEquals(BigDecimal.valueOf(0), result);
    }

    @Test
    void calculateProductGramsForRequiredFiller_zeroValue() {
        BigDecimal result = product.calculateProductGramsForRequiredFiller(Filler.CARBOHYDRATE, BigDecimal.valueOf(0));
        assertEquals(BigDecimal.valueOf(0), result);
    }

    @Test
    void isFiller_true() {
        assertTrue(product.isFiller());
    }

    @Test
    void isFiller_false() {
        product.setFiller(Filler.NONE);
        assertFalse(product.isFiller());
    }

    @Test
    void isFiller_nullFalse() {
        product.setFiller(null);
        assertFalse(product.isFiller());
    }
}