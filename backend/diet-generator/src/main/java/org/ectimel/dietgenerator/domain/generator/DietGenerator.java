package org.ectimel.dietgenerator.domain.generator;

import org.ectimel.dietgenerator.domain.calculator.macro.Macronutrient;
import org.ectimel.dietgenerator.domain.model.Diet;
import org.ectimel.dietgenerator.domain.model.Recipe;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

public class DietGenerator {

    private Macronutrient macronutrient;
    private List<Recipe> recipes;
    private List<Recipe> usedRecipes;
    private BigDecimal numberOfMeals;
    private BigDecimal requiredCalories;

    public DietGenerator( BigDecimal requiredCalories, BigDecimal numberOfMeals, Macronutrient macronutrient, List<Recipe> recipes) {
        this.macronutrient = macronutrient;
        this.recipes = recipes;
        this.numberOfMeals = numberOfMeals;
        this.requiredCalories = requiredCalories;
    }

    public Diet generateDiet() {

        Random random = new Random();
        int randomRecipeIdx = random.nextInt(recipes.size());

        Recipe recipe = recipes.get(randomRecipeIdx);
        usedRecipes.add(recipe);
        recipes.remove(randomRecipeIdx);




        return null;
    }



}
