package org.ectimel.dietgenerator.domain.model;

import org.ectimel.dietgenerator.domain.generator.diet.DietType;
import org.ectimel.dietgenerator.domain.model.nutrient.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecipeTest {

    private Recipe recipe;

    @BeforeEach
    void setUp() {

        Nutrients nutrients1 = new Nutrients(
                new Calories(new BigDecimal("650")),
                new Carbohydrates(new BigDecimal("20"), new BigDecimal("5"), new BigDecimal("10")),
                new Proteins(new BigDecimal("30")),
                new Fats(new BigDecimal("50"), new BigDecimal("20"))
        );

        Nutrients nutrients2 = new Nutrients(
                new Calories(new BigDecimal("650")),
                new Carbohydrates(new BigDecimal("20"), new BigDecimal("5"), new BigDecimal("10")),
                new Proteins(new BigDecimal("30")),
                new Fats(new BigDecimal("50"), new BigDecimal("20"))
        );

        Product product1 = Product.builder()
                .nutrients(nutrients1)
                .name("Product 1")
                .filler(Filler.NONE)
                .build();

        Product product2 = Product.builder()
                .nutrients(nutrients2)
                .name("Product 2")
                .filler(Filler.FAT)
                .build();

        Map<Product, BigDecimal> proportions = new HashMap<>();
        proportions.put(product1, BigDecimal.valueOf(100));
        proportions.put(product2, BigDecimal.valueOf(100));

        recipe = Recipe.builder()
                .ingredientsProportion(proportions)
                .isScalable(true)
                .dietType(List.of(DietType.PROTEIN))
                .mealTypes(List.of(MealType.BREAKFAST))
                .howToPrepare("Prepare")
                .name("Test recipe")
                .basePortionInGrams(BigDecimal.valueOf(200))
                .build();

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