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

    private Map<Product, BigDecimal> recipesToGrams;
    private Nutrients nutrients;

    private Dish(Map<Product, BigDecimal> recipesToGrams) {
        this.recipesToGrams = recipesToGrams;
        this.nutrients = calculateNutrients();
    }

    public static Dish createDish(Recipe recipe) {
        Map<Product, BigDecimal> calculatedRecipeToGram = new HashMap<>();
        recipe.getIngredientsProportion().forEach(((product, proportion) -> {
            calculatedRecipeToGram.put(product, recipe.getBasePortion()
                    .multiply(proportion.divide(BigDecimal.valueOf(100), 2, RoundingMode.FLOOR)));
        }));
        return new Dish(calculatedRecipeToGram);
    }

    public static Dish createDish(Recipe recipe, BigDecimal requiredCalories) {
        BigDecimal recipeTotalCalories = recipe.getNutrients().getCalories().getTotalCalories();
        BigDecimal factor = requiredCalories.divide(recipeTotalCalories, 3, RoundingMode.HALF_UP);
        Map<Product, BigDecimal> emptyRecipeToGram = new HashMap<>();
        recipe.getIngredientsProportion().forEach(((product, proportion) -> {
            emptyRecipeToGram.put(product, proportion.multiply(factor));
        }));
        return new Dish(emptyRecipeToGram);
    }

    private Nutrients calculateNutrients() {
        Nutrients mealNutrients = Nutrients.createEmptyNutrients();
        recipesToGrams.forEach(((product, bigDecimal) -> {
            mealNutrients.addNutrients(product.calculateNutrients(bigDecimal));
        }));
        return mealNutrients;
    }



}
