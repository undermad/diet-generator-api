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
public class Meal {

    private Map<Product, BigDecimal> recipesToGrams;
    private Nutrients nutrients;

    private Meal(Map<Product, BigDecimal> recipesToGrams) {
        this.recipesToGrams = recipesToGrams;
        nutrients = calculateNutrients();
    }

    public static Meal createMeal(Recipe recipe, BigDecimal requiredCalories) {
        BigDecimal recipeTotalCalories = recipe.getNutrients().getCalories().getTotalCalories();
        BigDecimal multiplayer = requiredCalories.divide(recipeTotalCalories, 2, RoundingMode.HALF_UP);
        Map<Product, BigDecimal> emptyRecipeToGram = new HashMap<>();
        recipe.getIngredientsProportion().forEach(((product, proportion) -> {
            emptyRecipeToGram.put(product, proportion.multiply(multiplayer));
        }));
        return new Meal(emptyRecipeToGram);
    }


    private Nutrients calculateNutrients() {
        Nutrients mealNutrients = Nutrients.createEmptyNutrients();
        recipesToGrams.forEach(((product, bigDecimal) -> {
            mealNutrients.addNutrients(product.calculateNutrients(bigDecimal));
        }));
        return mealNutrients;
    }

    // write method that fill te meal with missing macros

}
