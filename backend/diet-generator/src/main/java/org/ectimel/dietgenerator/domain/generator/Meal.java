package org.ectimel.dietgenerator.domain.generator;

import org.ectimel.dietgenerator.domain.model.Nutrients;
import org.ectimel.dietgenerator.domain.model.Product;
import org.ectimel.dietgenerator.domain.model.Recipe;

import java.math.BigDecimal;
import java.util.Map;

public class Meal {

    private Map<Product, BigDecimal> recipesToGrams;
    private Nutrients nutrients;

    public Meal(Map<Product, BigDecimal> recipesToGrams) {
        this.recipesToGrams = recipesToGrams;
        nutrients = calculateNutrients();
    }

    public Meal createMeal(Recipe recipe, BigDecimal calories) {
        // create meal from given calories
        
        return null;
    }


    private Nutrients calculateNutrients() {
        Nutrients mealNutrients = Nutrients.createEmptyNutrients();
        recipesToGrams.forEach(((product, bigDecimal) -> {
            mealNutrients.addNutrients(product.calculateNutrients(bigDecimal));
        }));
        return mealNutrients;
    }

    // write method that calculate nutrients of base portion
    // write method that calculate ingredients from given calories
    // write method that fill te meal with missing macros

}
