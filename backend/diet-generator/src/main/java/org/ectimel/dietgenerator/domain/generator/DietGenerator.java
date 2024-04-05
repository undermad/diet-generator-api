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
        fill(diet)
        return diet;
    }

    private void fill(Diet diet) {
        diet.getDishes().forEach(dish -> {

        });
    }

    private void addDishes(Diet diet) {
        addDish(diet, MealType.BREAKFAST);

        for (int i = 1; i < numberOfMeals.doubleValue() - 1; i++) {
            if(i == 3) {
                addDish(diet, MealType.SNACK);
                continue;
            }
            addDish(diet, MealType.LUNCH);
        }

        addDish(diet, MealType.DINNER);
    }

    private void addDish(Diet diet, MealType mealType) {
        Dish breakfast = getRandomDish(mealType);
        diet.addDish(breakfast);
        macronutrient.reduceValues(breakfast.getNutrients());
    }

    private Dish getRandomDish(MealType mealType) {
        List<Recipe> mealTypeRecipes = recipes.get(mealType);
        Recipe randomRecipe = mealTypeRecipes.get(random.nextInt(mealTypeRecipes.size()));
        return Dish.createDish(randomRecipe, baseCaloriesPerMeal);
    }



}
