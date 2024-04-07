package org.ectimel.dietgenerator.application.service;

import org.ectimel.dietgenerator.application.port.in.DietService;
import org.ectimel.dietgenerator.domain.calculator.macro.MacroCalculator;
import org.ectimel.dietgenerator.domain.calculator.macro.MacroCalculatorAttributes;
import org.ectimel.dietgenerator.domain.calculator.macro.MacroCalculatorFactory;
import org.ectimel.dietgenerator.domain.calculator.macro.Macronutrient;
import org.ectimel.dietgenerator.domain.generator.DietAttributes;
import org.ectimel.dietgenerator.domain.generator.DietGenerator;
import org.ectimel.dietgenerator.domain.generator.DietType;
import org.ectimel.dietgenerator.domain.model.Diet;
import org.ectimel.dietgenerator.domain.model.MealType;
import org.ectimel.dietgenerator.domain.model.Recipe;
import org.ectimel.dietgenerator.application.repositories.RecipeRepository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DietServiceImpl implements DietService {

    private final RecipeRepository recipeRepository;

    public DietServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Diet generateDiet(DietAttributes dietAttributes) {

        Macronutrient macronutrient = calculateMacronutrients(dietAttributes);
        System.out.println("Calories: " + macronutrient.getCalories().doubleValue());
        System.out.println("Carbohydrates: " + macronutrient.getCarbohydrates().doubleValue());
        System.out.println("Proteins: " + macronutrient.getProteins().doubleValue());
        System.out.println("Fats: " + macronutrient.getFats().doubleValue());

        Map<MealType, List<Recipe>> allRecipes = getAllSegregatedRecipes(dietAttributes.dietType());

        DietGenerator dietGenerator = new DietGenerator(
                dietAttributes.requiredCalories(),
                dietAttributes.numberOfMeals(),
                macronutrient,
                allRecipes);

        return dietGenerator.generateDiet();
    }

    private Map<MealType, List<Recipe>> getAllSegregatedRecipes(DietType dietType) {
        Map<MealType, List<Recipe>> allRecipes = new HashMap<>();
        Arrays.stream(MealType.values()).forEach(mealType -> {
            List<Recipe> mealTypeRecipes = recipeRepository.findAllByDietAndMealTypes(dietType, mealType);
            allRecipes.put(mealType, mealTypeRecipes);
        });
        return allRecipes;
    }

    private Macronutrient calculateMacronutrients(DietAttributes dietAttributes) {
        MacroCalculator macroCalculator = MacroCalculatorFactory.getMacroCalculator(dietAttributes.dietType());
        MacroCalculatorAttributes macroCalculatorAttributes = new MacroCalculatorAttributes(
                dietAttributes.requiredCalories(),
                dietAttributes.bodyWeightInKg(),
                dietAttributes.gender());
        return macroCalculator.calculate(macroCalculatorAttributes);
    }
    


}
