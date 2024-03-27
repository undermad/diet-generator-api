package org.ectimel.dietgenerator.domain.service;

import io.vavr.control.Try;
import org.ectimel.dietgenerator.domain.calculator.macro.MacroCalculator;
import org.ectimel.dietgenerator.domain.calculator.macro.MacroCalculatorAttributes;
import org.ectimel.dietgenerator.domain.calculator.macro.MacroCalculatorFactory;
import org.ectimel.dietgenerator.domain.calculator.macro.Macronutrient;
import org.ectimel.dietgenerator.domain.generator.DietAttributes;
import org.ectimel.dietgenerator.domain.generator.DietGenerator;
import org.ectimel.dietgenerator.domain.model.Diet;
import org.ectimel.dietgenerator.domain.model.Recipe;
import org.ectimel.dietgenerator.domain.port.in.DietService;
import org.ectimel.dietgenerator.domain.port.out.RecipeRepository;

import java.util.List;


public class DietServiceImpl implements DietService {

    private final RecipeRepository recipeRepository;

    public DietServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Diet generateDiet(DietAttributes dietAttributes) {

        MacroCalculator macroCalculator = MacroCalculatorFactory.getMacroCalculator(dietAttributes.dietType());
        MacroCalculatorAttributes macroCalculatorAttributes = new MacroCalculatorAttributes(
                dietAttributes.requiredCalories(),
                dietAttributes.bodyWeightInKg(),
                dietAttributes.gender());
        Macronutrient macronutrient = macroCalculator.calculate(macroCalculatorAttributes);

        List<Recipe> recipes = recipeRepository.findAllRecipesByDietType(dietAttributes.dietType());

        DietGenerator dietGenerator = new DietGenerator(
                dietAttributes.requiredCalories(),
                dietAttributes.numberOfMeals(),
                macronutrient,
                recipes);

        return dietGenerator.generateDiet();
    }
}
