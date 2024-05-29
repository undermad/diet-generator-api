package org.ectimel.dietgenerator.application.repositories;

import org.ectimel.dietgenerator.domain.model.DietType;
import org.ectimel.dietgenerator.domain.model.MealType;
import org.ectimel.dietgenerator.domain.model.Recipe;

import java.util.List;

public interface RecipeRepository {
    Recipe save(Recipe recipe);
    List<Recipe> findAllByDietAndMealTypes(DietType dietType, MealType mealType);
    List<Recipe> findByName(String name);
}
