package org.ectimel.dietgenerator.domain.model;

import org.ectimel.dietgenerator.domain.TestObjects;
import org.ectimel.dietgenerator.domain.model.nutrient.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {

    private Recipe recipe;

    @BeforeEach
    void setUp() {
        recipe = TestObjects.createTestRecipe();
    }

    @Test
    public void testConstructor_scalableFillers() {
        assertAll("Should be correct",
                () -> assertTrue(recipe.getScalableFillers().contains(Filler.FAT)),
                () -> assertFalse(recipe.getScalableFillers().contains(Filler.NONE))
        );
    }

    @Test
    public void testConstructor_calculateNutrients() {
        assertAll("Should be correct",
                () -> assertEquals(new BigDecimal("1300"), recipe.getNutrients().getCalories().getTotalCalories()),
                () -> assertEquals(new BigDecimal("40"), recipe.getNutrients().getCarbohydrates().getTotalCarbohydrates()),
                () -> assertEquals(new BigDecimal("60"), recipe.getNutrients().getProteins().getTotalProteins()),
                () -> assertEquals(new BigDecimal("100"), recipe.getNutrients().getFats().getTotalFats())
        );
    }


}