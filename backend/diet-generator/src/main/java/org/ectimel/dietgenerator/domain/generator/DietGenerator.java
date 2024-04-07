package org.ectimel.dietgenerator.domain.generator;

import org.ectimel.dietgenerator.domain.calculator.macro.Macronutrient;
import org.ectimel.dietgenerator.domain.model.Diet;
import org.ectimel.dietgenerator.domain.model.MealType;
import org.ectimel.dietgenerator.domain.model.Recipe;
import org.ectimel.dietgenerator.domain.model.nutrient.Filler;
import org.ectimel.dietgenerator.domain.model.nutrient.Nutrients;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class DietGenerator {

    private final Random random;

    Map<MealType, List<Recipe>> recipes;

    private Macronutrient macronutrients;

    private final BigDecimal requiredTotalCalories;
    private final BigDecimal reservedCalories;
    private final BigDecimal requiredCaloriesAfterReservation;
    private final BigDecimal numberOfMeals;
    private final BigDecimal baseCaloriesPerMeal;


    public DietGenerator(BigDecimal requiredTotalCalories, BigDecimal numberOfMeals, Macronutrient macronutrients, Map<MealType, List<Recipe>> recipes) {
        this.macronutrients = macronutrients;
        this.numberOfMeals = numberOfMeals;
        this.requiredTotalCalories = requiredTotalCalories;

        this.reservedCalories = requiredTotalCalories.multiply(BigDecimal.valueOf(0.1));
        this.requiredCaloriesAfterReservation = requiredTotalCalories.subtract(reservedCalories);
        this.baseCaloriesPerMeal = requiredCaloriesAfterReservation.divide(numberOfMeals, 2, RoundingMode.DOWN);
        this.random = new Random();
        this.recipes = recipes;
    }

    public Diet generateDiet() {
        Diet diet = new Diet();
        addDishes(diet);
        adjustMacronutrients(diet);
        return diet;
    }


    private void adjustMacronutrients(Diet diet) {
        int numberOfLoops = 10;
        for (int i = 0; i < numberOfLoops; i++) {
            if (macronutrients.getCarbohydrates().doubleValue() < 0)
                reduceMacronutrient(diet, Filler.CARBOHYDRATE, macronutrients.getCarbohydrates().abs());
            else
                increaseMacronutrient(diet, Filler.CARBOHYDRATE, macronutrients.getCarbohydrates());

            if (macronutrients.getFats().doubleValue() < 0)
                reduceMacronutrient(diet, Filler.FAT, macronutrients.getFats().abs());
            else
                increaseMacronutrient(diet, Filler.FAT, macronutrients.getFats());

            if (macronutrients.getProteins().doubleValue() < 0)
                reduceMacronutrient(diet, Filler.PROTEIN, macronutrients.getProteins().abs());
            else
                increaseMacronutrient(diet, Filler.PROTEIN, macronutrients.getProteins());

        }
    }

    private void increaseMacronutrient(Diet diet, Filler filler, BigDecimal amount) {
        List<Dish> scalableDishes = diet.getScalableDishesByFiller(filler);
        BigDecimal eachDishAmount = amount.divide(BigDecimal.valueOf(scalableDishes.size()), 2, RoundingMode.HALF_DOWN);
        for (Dish dish : scalableDishes) {
            Nutrients reducedNutrients = dish.increaseFiller(filler, eachDishAmount);
            macronutrients.increaseValues(reducedNutrients);
        }
    }

    private void reduceMacronutrient(Diet diet, Filler filler, BigDecimal amount) {
        List<Dish> scalableDishes = diet.getScalableDishesByFiller(filler);
        BigDecimal eachDishAmount = amount.divide(BigDecimal.valueOf(scalableDishes.size()), 2, RoundingMode.HALF_DOWN);
        for (Dish dish : scalableDishes) {
            Nutrients reducedNutrients = dish.reduceFiller(filler, eachDishAmount);
            macronutrients.reduceValues(reducedNutrients);
        }

    }


    private void addDishes(Diet diet) {
        addDish(diet, MealType.BREAKFAST);
        for (int i = 1; i < numberOfMeals.doubleValue() - 1; i++) {
            if (i == 3) {
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
        macronutrients.reduceValues(breakfast.getNutrients());
    }

    private Dish getRandomDish(MealType mealType) {
        List<Recipe> mealTypeRecipes = recipes.get(mealType);
        Recipe randomRecipe = mealTypeRecipes.get(random.nextInt(mealTypeRecipes.size()));
        return Dish.createDish(randomRecipe, baseCaloriesPerMeal);
    }


}
