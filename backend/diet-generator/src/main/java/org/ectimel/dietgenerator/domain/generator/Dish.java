package org.ectimel.dietgenerator.domain.generator;

import lombok.Getter;
import org.ectimel.dietgenerator.domain.model.Nutrients;
import org.ectimel.dietgenerator.domain.model.Product;
import org.ectimel.dietgenerator.domain.model.Recipe;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

@Getter
public class Dish {

    private Map<Product, BigDecimal> productToGrams;
    private Nutrients nutrients;
    private Recipe recipe;

    private Dish(Map<Product, BigDecimal> productToGrams, Recipe recipe) {
        this.productToGrams = productToGrams;
        this.nutrients = calculateNutrients();
        this.recipe = recipe;
    }

    public static Dish createDish(Recipe recipe) {
        Map<Product, BigDecimal> calculatedRecipeToGram = new HashMap<>();
        recipe.getIngredientsProportion().forEach(((product, proportion) -> {
            calculatedRecipeToGram.put(product, recipe.getBasePortion()
                    .multiply(proportion.divide(BigDecimal.valueOf(100), 2, RoundingMode.FLOOR)));
        }));
        return new Dish(calculatedRecipeToGram, recipe);
    }

    public static Dish createDish(Recipe recipe, BigDecimal requiredCalories) {
        BigDecimal recipeTotalCalories = recipe.getNutrients().getCalories().getTotalCalories();
        BigDecimal factor = requiredCalories.divide(recipeTotalCalories, 3, RoundingMode.HALF_UP);
        Map<Product, BigDecimal> emptyRecipeToGram = new HashMap<>();
        recipe.getIngredientsProportion().forEach(((product, proportion) -> {
            emptyRecipeToGram.put(product, proportion.multiply(factor));
        }));
        return new Dish(emptyRecipeToGram, recipe);
    }

    private Nutrients calculateNutrients() {
        Nutrients mealNutrients = Nutrients.createEmptyNutrients();
        productToGrams.forEach(((product, bigDecimal) -> {
            mealNutrients.addNutrients(product.calculateNutrients(bigDecimal));
        }));
        return mealNutrients;
    }

}
