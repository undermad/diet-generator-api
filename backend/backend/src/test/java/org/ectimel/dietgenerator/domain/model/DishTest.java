package org.ectimel.dietgenerator.domain.model;

import org.ectimel.dietgenerator.domain.TestObjects;
import org.ectimel.dietgenerator.domain.model.nutrient.Filler;
import org.ectimel.dietgenerator.domain.model.nutrient.Nutrients;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.plaf.basic.BasicDesktopIconUI;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

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
    void increaseFiller_positiveValue() {
        Dish dish = Dish.createDish(recipe, BigDecimal.valueOf(1300));
        dish.increaseFiller(Filler.FAT, BigDecimal.valueOf(5));

        assertAll("Should add the values",
                () -> assertEquals(new BigDecimal("1365"), dish.getNutrients().getCalories().getTotalCalories()),
                () -> assertEquals(new BigDecimal("42"), dish.getNutrients().getCarbohydrates().getTotalCarbohydrates()),
                () -> assertEquals(new BigDecimal("63"), dish.getNutrients().getProteins().getTotalProteins()),
                () -> assertEquals(new BigDecimal("105"), dish.getNutrients().getFats().getTotalFats()));

    }

    @Test
    void increaseFiller_negativeValue() {
        Dish dish = Dish.createDish(recipe, BigDecimal.valueOf(1300));
        Nutrients addedNutrients = dish.increaseFiller(Filler.FAT, BigDecimal.valueOf(-5));

        assertAll("Should not change the values",
                () -> assertEquals(new BigDecimal("1300"), dish.getNutrients().getCalories().getTotalCalories()),
                () -> assertEquals(new BigDecimal("40"), dish.getNutrients().getCarbohydrates().getTotalCarbohydrates()),
                () -> assertEquals(new BigDecimal("60"), dish.getNutrients().getProteins().getTotalProteins()),
                () -> assertEquals(new BigDecimal("100"), dish.getNutrients().getFats().getTotalFats()));

        assertAll("Should return empty nutrients.",
                () -> assertEquals(new BigDecimal("0"), addedNutrients.getCalories().getTotalCalories()),
                () -> assertEquals(new BigDecimal("0"), addedNutrients.getCarbohydrates().getTotalCarbohydrates()),
                () -> assertEquals(new BigDecimal("0"), addedNutrients.getProteins().getTotalProteins()),
                () -> assertEquals(new BigDecimal("0"), addedNutrients.getFats().getTotalFats()));
    }

    @Test
    void increaseFiller_nullValue() {
        Dish dish = Dish.createDish(recipe, BigDecimal.valueOf(1300));
        Nutrients addedNutrients = dish.increaseFiller(Filler.CARBOHYDRATE, null);
        Nutrients addedNutrients2 = dish.increaseFiller(null, BigDecimal.valueOf(1));
        Nutrients addedNutrients3 = dish.increaseFiller(Filler.NONE, BigDecimal.valueOf(1));

        assertAll("Should not change the values",
                () -> assertEquals(new BigDecimal("1300"), dish.getNutrients().getCalories().getTotalCalories()),
                () -> assertEquals(new BigDecimal("40"), dish.getNutrients().getCarbohydrates().getTotalCarbohydrates()),
                () -> assertEquals(new BigDecimal("60"), dish.getNutrients().getProteins().getTotalProteins()),
                () -> assertEquals(new BigDecimal("100"), dish.getNutrients().getFats().getTotalFats()));
    }


    @Test
    void reduceFiller_positiveValue() {
        Dish dish = Dish.createDish(recipe, BigDecimal.valueOf(1300));
        dish.reduceFiller(Filler.FAT, BigDecimal.valueOf(5));

        assertAll("Should add the values",
                () -> assertEquals(new BigDecimal("1235"), dish.getNutrients().getCalories().getTotalCalories()),
                () -> assertEquals(new BigDecimal("38"), dish.getNutrients().getCarbohydrates().getTotalCarbohydrates()),
                () -> assertEquals(new BigDecimal("57"), dish.getNutrients().getProteins().getTotalProteins()),
                () -> assertEquals(new BigDecimal("95"), dish.getNutrients().getFats().getTotalFats()));

    }

    @Test
    void reduceFiller_negativeValue() {
        Dish dish = Dish.createDish(recipe, BigDecimal.valueOf(1300));
        Nutrients addedNutrients = dish.reduceFiller(Filler.FAT, BigDecimal.valueOf(-5));

        assertAll("Should not change the values",
                () -> assertEquals(new BigDecimal("1300"), dish.getNutrients().getCalories().getTotalCalories()),
                () -> assertEquals(new BigDecimal("40"), dish.getNutrients().getCarbohydrates().getTotalCarbohydrates()),
                () -> assertEquals(new BigDecimal("60"), dish.getNutrients().getProteins().getTotalProteins()),
                () -> assertEquals(new BigDecimal("100"), dish.getNutrients().getFats().getTotalFats()));

        assertAll("Should return empty nutrients.",
                () -> assertEquals(new BigDecimal("0"), addedNutrients.getCalories().getTotalCalories()),
                () -> assertEquals(new BigDecimal("0"), addedNutrients.getCarbohydrates().getTotalCarbohydrates()),
                () -> assertEquals(new BigDecimal("0"), addedNutrients.getProteins().getTotalProteins()),
                () -> assertEquals(new BigDecimal("0"), addedNutrients.getFats().getTotalFats()));
    }

    @Test
    void reduceFiller_nullValue() {
        Dish dish = Dish.createDish(recipe, BigDecimal.valueOf(1300));
        Nutrients addedNutrients = dish.increaseFiller(Filler.CARBOHYDRATE, null);
        Nutrients addedNutrients2 = dish.increaseFiller(null, BigDecimal.valueOf(1));
        Nutrients addedNutrients3 = dish.increaseFiller(Filler.NONE, BigDecimal.valueOf(1));

        assertAll("Should not change the values",
                () -> assertEquals(new BigDecimal("1300"), dish.getNutrients().getCalories().getTotalCalories()),
                () -> assertEquals(new BigDecimal("40"), dish.getNutrients().getCarbohydrates().getTotalCarbohydrates()),
                () -> assertEquals(new BigDecimal("60"), dish.getNutrients().getProteins().getTotalProteins()),
                () -> assertEquals(new BigDecimal("100"), dish.getNutrients().getFats().getTotalFats()));
    }

    @Test
    void testCreateDish() {
    }



}