package org.ectimel.dietgenerator.application.port.in;

import org.ectimel.dietgenerator.domain.model.Recipe;

import java.util.List;
import java.util.UUID;

public interface RecipeService {
    List<Recipe> getRecipe(String productName);
    Recipe getRecipe(UUID uuid);
}
