package org.ectimel.dietgenerator.domain.generator;

import lombok.Builder;
import lombok.NonNull;
import org.ectimel.dietgenerator.domain.calculator.macro.Macronutrient;
import org.ectimel.dietgenerator.domain.model.Diet;
import org.ectimel.dietgenerator.domain.model.MealType;
import org.ectimel.dietgenerator.domain.model.Recipe;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class DietGenerator {

    private final Random random;

    Map<MealType, List<Recipe>> recipes;

    private Macronutrient macronutrient;

    private final BigDecimal requiredTotalCalories;
    private final BigDecimal reservedCalories;
    private final BigDecimal requiredCaloriesAfterReservation;
    private final BigDecimal numberOfMeals;
    private final BigDecimal baseCaloriesPerMeal;


    public DietGenerator(BigDecimal requiredTotalCalories, BigDecimal numberOfMeals, Macronutrient macronutrient, Map<MealType, List<Recipe>> recipes) {
        this.macronutrient = macronutrient;
        this.numberOfMeals = numberOfMeals;
        this.requiredTotalCalories = requiredTotalCalories;

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
        Dish breakfast = getRandomDish(MealType.BREAKFAST);
        diet.addDish(breakfast);

        for (int i = 1; i < numberOfMeals.doubleValue() - 1; i++) {
            Dish dish;
            if(i == 3) dish = getRandomDish(MealType.SNACK);
            else dish = getRandomDish(MealType.LUNCH);
            diet.addDish(dish);
        }

        Dish dinner = getRandomDish(MealType.DINNER);
        diet.addDish(dinner);
    }

    private Dish getRandomDish(MealType mealType) {
        List<Recipe> mealTypeRecipes = recipes.get(mealType);
        Recipe randomRecipe = mealTypeRecipes.get(random.nextInt(mealTypeRecipes.size()));
        return Dish.createDish(randomRecipe, baseCaloriesPerMeal);
    }



}
