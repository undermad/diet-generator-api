package org.ectimel.dietgenerator.domain.port.out;

import org.ectimel.dietgenerator.domain.model.Recipe;

import java.util.List;

public interface RecipeRepository {
    List<Recipe> findAllRecipes();
    Recipe save(Recipe recipe);
}
