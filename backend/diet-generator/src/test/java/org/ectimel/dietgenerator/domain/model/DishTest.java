package org.ectimel.dietgenerator.domain.model;

import org.ectimel.dietgenerator.domain.TestObjects;
import org.ectimel.dietgenerator.domain.model.nutrient.Filler;
import org.ectimel.dietgenerator.domain.model.nutrient.Nutrients;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DishTest {

    private Recipe recipe;


    @BeforeEach
    void setUp() {
        recipe = TestObjects.createTestRecipe();
    }

    @Test
    void createDish_numberOfFillers() {
        Dish dish = Dish.createDish(recipe, BigDecimal.valueOf(1300));


        assertAll("Should be correct",
                () -> assertEquals(3, dish.getNumberOfFillers().size()),
                () -> assertEquals(1, dish.getNumberOfFillers().get(Filler.FAT))
                );
    }

    @Test
    void calculateNutrients_positiveValue() {
        Dish dish = Dish.createDish(recipe, BigDecimal.valueOf(1300));

        assertAll("Should double the values",
                () -> assertEquals(new BigDecimal("1300"), dish.getNutrients().getCalories().getTotalCalories()),
                () -> assertEquals(new BigDecimal("40"), dish.getNutrients().getCarbohydrates().getTotalCarbohydrates()),
                () -> assertEquals(new BigDecimal("60"), dish.getNutrients().getProteins().getTotalProteins()),
                () -> assertEquals(new BigDecimal("100"), dish.getNutrients().getFats().getTotalFats()));
    }

    @Test
    void testCreateDish() {
    }

    @Test
    void increaseFiller() {
    }

    @Test
    void reduceFiller() {
    }
}