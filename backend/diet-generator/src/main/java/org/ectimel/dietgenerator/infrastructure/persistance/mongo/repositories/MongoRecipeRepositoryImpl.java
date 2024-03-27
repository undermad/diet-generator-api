package org.ectimel.dietgenerator.infrastructure.persistance.mongo.repositories;

import org.ectimel.dietgenerator.domain.generator.DietType;
import org.ectimel.dietgenerator.domain.model.Recipe;
import org.ectimel.dietgenerator.domain.port.out.RecipeRepository;
import org.ectimel.dietgenerator.infrastructure.persistance.mongo.mappers.RecipeMapper;
import org.ectimel.dietgenerator.infrastructure.persistance.mongo.models.RecipeDocument;
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
    public List<Recipe> findAllRecipesByDietType(DietType dietType) {
        List<RecipeDocument> recipes = springDataMongoRecipeRepository.findAllByDietType(dietType);
        return recipes.stream()
                .map(recipeMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Recipe save(Recipe recipe) {
        RecipeDocument savedRecipeDocument = springDataMongoRecipeRepository.save(recipeMapper.mapFromDomain(recipe));

        return recipeMapper.mapToDomain(savedRecipeDocument);
    }
}
