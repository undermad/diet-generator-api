package org.ectimel.dietgenerator.domain;

import org.ectimel.dietgenerator.domain.model.DietType;
import org.ectimel.dietgenerator.domain.model.MealType;
import org.ectimel.dietgenerator.domain.model.Product;
import org.ectimel.dietgenerator.domain.model.Recipe;
import org.ectimel.dietgenerator.domain.model.nutrient.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestObjects {

    public static Recipe createTestRecipe() {
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

        return Recipe.builder()
                .ingredientsProportion(proportions)
                .isScalable(true)
                .dietType(List.of(DietType.PROTEIN))
                .mealTypes(List.of(MealType.BREAKFAST))
                .howToPrepare("Prepare")
                .name("Test recipe")
                .basePortionInGrams(BigDecimal.valueOf(200))
                .build();
    }

    public static Nutrients createTestNutrients() {
        return new Nutrients(
                new Calories(new BigDecimal("650")),
                new Carbohydrates(new BigDecimal("20"), new BigDecimal("5"), new BigDecimal("10")),
                new Proteins(new BigDecimal("30")),
                new Fats(new BigDecimal("50"), new BigDecimal("20"))
        );
    }


}
