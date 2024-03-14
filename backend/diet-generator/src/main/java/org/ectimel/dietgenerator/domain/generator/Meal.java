package org.ectimel.dietgenerator.domain.generator;

import org.ectimel.dietgenerator.domain.model.Nutrients;
import org.ectimel.dietgenerator.domain.model.Recipe;

import java.math.BigDecimal;
import java.util.Map;

public class Meal {

    private Map<Recipe, BigDecimal> recipesToGrams;
    private Nutrients nutrients;

    public Meal(Map<Recipe, BigDecimal> recipesToGrams) {
        this.recipesToGrams = recipesToGrams;
        nutrients = calculateNutrients();
    }

    private Nutrients calculateNutrients(){
        Nutrients mealNutrients = Nutrients.createEmptyNutrients();
        recipesToGrams.forEach(((recipe, bigDecimal) -> {
            mealNutrients.addNutrients(recipe.calculateNutrients(bigDecimal));
        }));
        return mealNutrients;
    }

    // write method that calculate nutrients of base portion
    // write method that calculate ingredients from given calories
    // write method that fill te meal with missing macros

}
