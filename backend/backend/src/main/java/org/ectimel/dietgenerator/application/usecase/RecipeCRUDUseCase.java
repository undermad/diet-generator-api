package org.ectimel.dietgenerator.application.usecase;

import org.ectimel.dietgenerator.application.repositories.RecipeRepository;
import org.ectimel.dietgenerator.domain.model.Recipe;

import java.util.List;
import java.util.UUID;

public class RecipeCRUDUseCase implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeCRUDUseCase(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> getRecipe(String productName) {
        return recipeRepository.findByName(productName);
    }

    @Override
    public Recipe getRecipe(UUID uuid) {
        return null;
    }
}
