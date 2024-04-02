package org.ectimel.dietgenerator.domain.generator;

import lombok.Builder;
import lombok.NonNull;
import org.ectimel.dietgenerator.domain.calculator.macro.Macronutrient;
import org.ectimel.dietgenerator.domain.model.Diet;
import org.ectimel.dietgenerator.domain.model.Recipe;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DietGenerator {

    private final Random random;

    private final List<Recipe> breakfastRecipes;
    private final List<Recipe> lunchRecipes;
    private final List<Recipe> dinnerRecipes;
    private final List<Recipe> snackRecipes;

    private Macronutrient macronutrient;

    private final BigDecimal requiredTotalCalories;
    private final BigDecimal reservedCalories;
    private final BigDecimal requiredCaloriesAfterReservation;
    private final BigDecimal numberOfMeals;
    private final BigDecimal baseCaloriesPerMeal;


    public DietGenerator(BigDecimal requiredTotalCalories, BigDecimal numberOfMeals, Macronutrient macronutrient, List<Recipe> recipes) {
        this.macronutrient = macronutrient;
        this.numberOfMeals = numberOfMeals;
        this.requiredTotalCalories = requiredTotalCalories;
        this.breakfastRecipes = new ArrayList<>();
        this.lunchRecipes = new ArrayList<>();
        this.dinnerRecipes = new ArrayList<>();
        this.snackRecipes = new ArrayList<>();
        segregateRecipes(recipes);

        this.reservedCalories = requiredTotalCalories.multiply(BigDecimal.valueOf(0.1));
        this.requiredCaloriesAfterReservation = requiredTotalCalories.subtract(reservedCalories);
        this.baseCaloriesPerMeal = requiredCaloriesAfterReservation.divide(numberOfMeals, 2, RoundingMode.DOWN);
        this.random = new Random();
    }

    public Diet generateDiet() {
        Diet diet = new Diet();
        addDishes(diet);

        return diet;
    }

    private void addDishes(Diet diet) {
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
