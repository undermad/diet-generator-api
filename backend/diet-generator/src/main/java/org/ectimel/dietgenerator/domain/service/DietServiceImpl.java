package org.ectimel.dietgenerator.domain.service;

import org.ectimel.dietgenerator.domain.model.Diet;
import org.ectimel.dietgenerator.domain.port.in.DietService;
import org.ectimel.dietgenerator.domain.port.out.RecipeRepository;

import java.math.BigDecimal;

public class DietServiceImpl implements DietService {

    private RecipeRepository recipeRepository;

    public DietServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Diet generateDiet(BigDecimal requiredCalories) {


        return null;
    }
}
