package org.ectimel.dietgenerator.domain.generator.diet;

import org.ectimel.dietgenerator.domain.calculator.macro.Macronutrient;
import org.ectimel.dietgenerator.domain.generator.shopping_list.ShoppingListGenerator;
import org.ectimel.dietgenerator.domain.model.Diet;
import org.ectimel.dietgenerator.domain.model.Dish;
import org.ectimel.dietgenerator.domain.model.MealType;
import org.ectimel.dietgenerator.domain.model.Recipe;
import org.ectimel.dietgenerator.domain.model.nutrient.Filler;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class DietGeneratorImpl implements DietGenerator {

    private final Random random;

    private Map<MealType, List<Recipe>> recipes;

    private Macronutrient missingMacronutrients;

    private final BigDecimal reservedCalories;
    private final BigDecimal requiredCaloriesAfterReservation;
    private final BigDecimal numberOfMeals;
    private final BigDecimal baseCaloriesPerMeal;


    public DietGeneratorImpl(BigDecimal numberOfMeals, Macronutrient missingMacronutrients, Map<MealType, List<Recipe>> recipes) {
        this.missingMacronutrients = missingMacronutrients;
        this.numberOfMeals = numberOfMeals;

        this.reservedCalories = missingMacronutrients.getCalories().multiply(BigDecimal.valueOf(0.1));
        this.requiredCaloriesAfterReservation = missingMacronutrients.getCalories().subtract(reservedCalories);
        this.baseCaloriesPerMeal = requiredCaloriesAfterReservation.divide(numberOfMeals, 2, RoundingMode.DOWN);
        this.random = new Random();
        this.recipes = recipes;
    }

    @Override
    public Diet generateDiet() {
        Diet diet = new Diet();
        addDishes(diet);
        adjustMacronutrients(diet);
        diet.setShoppingList(ShoppingListGenerator.generateShoppingList(diet));
        return diet;
    }


    private void adjustMacronutrients(Diet diet) {
        int numberOfLoops = 3;
        for (int i = 0; i < numberOfLoops; i++) {
            if (missingMacronutrients.getCarbohydrates().doubleValue() < 0)
                diet.reduceMacronutrient(Filler.CARBOHYDRATE, missingMacronutrients.getCarbohydrates().abs(), missingMacronutrients);
            else
                diet.increaseMacronutrient(Filler.CARBOHYDRATE, missingMacronutrients.getCarbohydrates(), missingMacronutrients);

            if (missingMacronutrients.getFats().doubleValue() < 0)
                diet.reduceMacronutrient(Filler.FAT, missingMacronutrients.getFats().abs(), missingMacronutrients);
            else
                diet.increaseMacronutrient(Filler.FAT, missingMacronutrients.getFats(), missingMacronutrients);

            if (missingMacronutrients.getProteins().doubleValue() < 0)
                diet.reduceMacronutrient(Filler.PROTEIN, missingMacronutrients.getProteins().abs(), missingMacronutrients);
            else
                diet.increaseMacronutrient(Filler.PROTEIN, missingMacronutrients.getProteins(), missingMacronutrients);

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
        missingMacronutrients.reduceValues(breakfast.getNutrients());
    }

    private Dish getRandomDish(MealType mealType) {
        List<Recipe> mealTypeRecipes = recipes.get(mealType);
        Recipe randomRecipe = mealTypeRecipes.get(random.nextInt(mealTypeRecipes.size()));
        return Dish.createDish(randomRecipe, baseCaloriesPerMeal);
    }


}
