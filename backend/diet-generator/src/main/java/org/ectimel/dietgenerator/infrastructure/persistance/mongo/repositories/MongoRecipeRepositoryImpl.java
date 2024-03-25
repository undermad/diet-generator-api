package org.ectimel.dietgenerator.infrastructure.persistance.mongo.repositories;

import org.ectimel.dietgenerator.domain.model.Recipe;
import org.ectimel.dietgenerator.domain.port.out.RecipeRepository;
import org.ectimel.dietgenerator.infrastructure.persistance.mongo.mappers.RecipeMapper;
import org.ectimel.dietgenerator.infrastructure.persistance.mongo.models.RecipeDocument;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public List<Recipe> findAllRecipes() {
        return null;
    }

    @Override
    public Recipe save(Recipe recipe) {
        RecipeDocument savedRecipeDocument = springDataMongoRecipeRepository.save(recipeMapper.mapToEntity(recipe));

        return recipeMapper.mapToDomain(savedRecipeDocument);
    }
}
