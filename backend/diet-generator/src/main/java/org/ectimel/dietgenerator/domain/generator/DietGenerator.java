package org.ectimel.dietgenerator.domain.generator;

import org.ectimel.dietgenerator.domain.calculator.macro.Macronutrient;
import org.ectimel.dietgenerator.domain.model.Diet;
import org.ectimel.dietgenerator.domain.model.MealType;
import org.ectimel.dietgenerator.domain.model.Recipe;
import org.ectimel.dietgenerator.domain.model.nutrient.Filler;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

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
    }

    public Diet generateDiet() {
        Diet diet = new Diet();
        addDishes(diet);
        fill(diet);
        return diet;
    }

    private void fill(Diet diet) {

        // you need to take care that each filling cycle, other macro need to be updated!!!!
    }

    private void adjustMacronutrients(Diet diet) {
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

    private void increaseMacronutrient(Diet diet, Filler filler, BigDecimal amount) {

    }

    private void reduceMacronutrient(Diet diet, Filler filler, BigDecimal amount) {
        AtomicReference<BigDecimal> eachMealAmount = new AtomicReference<>(amount.divide(BigDecimal.valueOf(diet.getDishes().size()), 2, RoundingMode.HALF_DOWN));
        AtomicReference<BigDecimal> currentAmount = new AtomicReference<>(BigDecimal.valueOf(amount.doubleValue()));
        AtomicInteger allDishesAmount = new AtomicInteger(diet.getDishes().size());
        diet.getDishes().forEach(dish -> {
            allDishesAmount.getAndDecrement();
            if (dish.reduceFiller(filler, eachMealAmount.get()))
                currentAmount.set(currentAmount.get().subtract(eachMealAmount.get()));
            else
                eachMealAmount.set(eachMealAmount.get().add(eachMealAmount.get().divide(BigDecimal.valueOf(allDishesAmount.get()), 2, RoundingMode.HALF_DOWN)));
        });

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
