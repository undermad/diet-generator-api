package org.ectimel.dietgenerator.application.usecase;

import org.ectimel.dietgenerator.application.port.in.CreateDiet;
import org.ectimel.dietgenerator.domain.calculator.macro.MacroCalculator;
import org.ectimel.dietgenerator.domain.calculator.macro.MacroCalculatorAttributes;
import org.ectimel.dietgenerator.domain.calculator.macro.MacroCalculatorFactory;
import org.ectimel.dietgenerator.domain.calculator.macro.Macronutrient;
import org.ectimel.dietgenerator.domain.generator.diet.DietAttributes;
import org.ectimel.dietgenerator.domain.generator.diet.DietGenerator;
import org.ectimel.dietgenerator.domain.generator.diet.DietGeneratorImpl;
import org.ectimel.dietgenerator.domain.generator.diet.DietType;
import org.ectimel.dietgenerator.domain.model.Diet;
import org.ectimel.dietgenerator.domain.model.MealType;
import org.ectimel.dietgenerator.domain.model.Recipe;
import org.ectimel.dietgenerator.application.repositories.RecipeRepository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CreateDietUseCase implements CreateDiet {

    private final RecipeRepository recipeRepository;

    public CreateDietUseCase(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Diet createDiet(DietAttributes dietAttributes) {

        Macronutrient macronutrient = calculateMacronutrients(dietAttributes);
        Map<MealType, List<Recipe>> allRecipes = getAllSegregatedRecipes(dietAttributes.dietType());

        DietGenerator dietGeneratorImpl = new DietGeneratorImpl(
                dietAttributes.numberOfMeals(),
                macronutrient,
                allRecipes);

        return dietGeneratorImpl.generateDiet();
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
