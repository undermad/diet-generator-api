package org.ectimel.dietgenerator.application.repositories;

import org.ectimel.dietgenerator.domain.generator.DietType;
import org.ectimel.dietgenerator.domain.model.MealType;
import org.ectimel.dietgenerator.domain.model.Recipe;

import java.util.List;

public interface RecipeRepository {
    List<Recipe> findAllByDietType(DietType dietType);
    Recipe save(Recipe recipe);
    List<Recipe> findAllByDietAndMealTypes(DietType dietType, MealType mealType);
}
