package org.ectimel.dietgenerator.domain.generator;

import org.ectimel.dietgenerator.domain.calculator.macro.Macronutrient;
import org.ectimel.dietgenerator.domain.model.Diet;
import org.ectimel.dietgenerator.domain.model.Recipe;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DietGenerator {

    private Macronutrient macronutrient;
    private BigDecimal numberOfMeals;
    private BigDecimal requiredCalories;

    private List<Recipe> breakfastRecipes;
    private List<Recipe> lunchRecipes;
    private List<Recipe> dinnerRecipes;
    private List<Recipe> snackRecipes;

    private BigDecimal baseCaloriesPerMeal;
    private Random random;


    public DietGenerator(BigDecimal requiredCalories, BigDecimal numberOfMeals, Macronutrient macronutrient, List<Recipe> recipes) {
        this.macronutrient = macronutrient;
        this.numberOfMeals = numberOfMeals;
        this.requiredCalories = requiredCalories;
        this.breakfastRecipes = new ArrayList<>();
        this.lunchRecipes = new ArrayList<>();
        this.dinnerRecipes = new ArrayList<>();
        this.snackRecipes = new ArrayList<>();
        segregateRecipes(recipes);
        this.baseCaloriesPerMeal = requiredCalories.divide(numberOfMeals, 2, RoundingMode.DOWN);
        this.random = new Random();
    }

    public Diet generateDiet() {
        Diet diet = new Diet();

        Dish breakfast = getRandomDish(breakfastRecipes);
        diet.addDish(breakfast);

        for (int i = 1; i < numberOfMeals.doubleValue() - 1; i++) {
            Dish dish;
            if(i == 3) dish = getRandomDish(snackRecipes);
            else dish = getRandomDish(lunchRecipes);
            diet.addDish(dish);
        }

        Dish dinner = getRandomDish(dinnerRecipes);
        diet.addDish(dinner);

        return diet;
    }

    private Dish getRandomDish(List<Recipe> recipes) {
        Recipe recipe = recipes.get(random.nextInt(recipes.size()));
        return Dish.createDish(recipe, baseCaloriesPerMeal);
    }


    private void segregateRecipes(List<Recipe> allRecipes) {
        allRecipes.forEach(recipe -> {
            recipe.getMealTypes().forEach(mealType -> {
                switch (mealType) {
                    case BREAKFAST -> breakfastRecipes.add(recipe);
                    case LUNCH -> lunchRecipes.add(recipe);
                    case SNACK -> snackRecipes.add(recipe);
                    case DINNER -> dinnerRecipes.add(recipe);
                }
            });
        });

    }


}
