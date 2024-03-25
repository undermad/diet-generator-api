package org.ectimel.dietgenerator.domain.generator;

import org.ectimel.dietgenerator.domain.calculator.macro.Macronutrient;
import org.ectimel.dietgenerator.domain.model.Recipe;

import java.util.List;

public class DietGenerator {

    private Macronutrient macroCalculator;
    private List<Recipe> recipes;

    public DietGenerator(Macronutrient macroCalculator, List<Recipe> recipes) {
        this.macroCalculator = macroCalculator;
        this.recipes = recipes;
    }



}
