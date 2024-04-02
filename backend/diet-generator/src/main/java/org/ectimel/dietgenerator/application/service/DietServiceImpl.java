package org.ectimel.dietgenerator.application.service;

import org.ectimel.dietgenerator.application.port.in.DietService;
import org.ectimel.dietgenerator.domain.calculator.macro.MacroCalculator;
import org.ectimel.dietgenerator.domain.calculator.macro.MacroCalculatorAttributes;
import org.ectimel.dietgenerator.domain.calculator.macro.MacroCalculatorFactory;
import org.ectimel.dietgenerator.domain.calculator.macro.Macronutrient;
import org.ectimel.dietgenerator.domain.generator.DietAttributes;
import org.ectimel.dietgenerator.domain.generator.DietGenerator;
import org.ectimel.dietgenerator.domain.model.Diet;
import org.ectimel.dietgenerator.domain.model.Recipe;
import org.ectimel.dietgenerator.application.repositories.RecipeRepository;

import java.util.List;


public class DietServiceImpl implements DietService {

    private final RecipeRepository recipeRepository;

    public DietServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Diet generateDiet(DietAttributes dietAttributes) {

        Macronutrient macronutrient = calculateMacronutrients(dietAttributes);
        System.out.println("Required calories: " + macronutrient.calories().doubleValue());
        System.out.println("Required proteins: " + macronutrient.proteins().doubleValue());
        System.out.println("Required carbohydrates: " + macronutrient.carbohydrates().doubleValue());
        System.out.println("Required fats: " + macronutrient.fats().doubleValue());
        List<Recipe> recipes = recipeRepository.findAllRecipesByDietType(dietAttributes.dietType());

        DietGenerator dietGenerator = new DietGenerator(
                dietAttributes.requiredCalories(),
                dietAttributes.numberOfMeals(),
                macronutrient,
                recipes);

        return dietGenerator.generateDiet();
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
