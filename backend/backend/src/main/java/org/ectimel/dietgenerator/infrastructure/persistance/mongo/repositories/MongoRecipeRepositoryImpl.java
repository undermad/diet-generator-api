package org.ectimel.dietgenerator.infrastructure.persistance.mongo.repositories;

import org.ectimel.dietgenerator.domain.model.DietType;
import org.ectimel.dietgenerator.domain.model.MealType;
import org.ectimel.dietgenerator.domain.model.Recipe;
import org.ectimel.dietgenerator.application.repositories.RecipeRepository;
import org.ectimel.dietgenerator.infrastructure.persistance.mongo.mappers.RecipeMapper;
import org.ectimel.dietgenerator.infrastructure.persistance.mongo.documents.RecipeDocument;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@Qualifier("mongoRecipeRepositoryImpl")
public class MongoRecipeRepositoryImpl implements RecipeRepository {

    private final SpringDataMongoRecipeRepository springDataMongoRecipeRepository;
    private final RecipeMapper recipeMapper;

    public MongoRecipeRepositoryImpl(SpringDataMongoRecipeRepository springDataMongoRecipeRepository, RecipeMapper recipeMapper) {
        this.springDataMongoRecipeRepository = springDataMongoRecipeRepository;
        this.recipeMapper = recipeMapper;
    }

    @Override
    public List<Recipe> findAllByDietAndMealTypes(DietType dietType, MealType mealType) {
        List<RecipeDocument> recipes = springDataMongoRecipeRepository.findAllByDietAndMealTypes(dietType, mealType);
        return recipes.stream()
                .map(recipeMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Recipe> findByName(String name) {
        List<RecipeDocument> recipeDocument = springDataMongoRecipeRepository.findByName(name);
        return recipeDocument.stream().map(recipeMapper::mapToDomain).collect(Collectors.toList());
    }

    @Override
    public Recipe save(Recipe recipe) {
        RecipeDocument savedRecipeDocument = springDataMongoRecipeRepository.save(recipeMapper.mapFromDomain(recipe));

        return recipeMapper.mapToDomain(savedRecipeDocument);
    }
}
