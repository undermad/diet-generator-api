package org.ectimel.dietgenerator.infrastructure.persistance.mongo.repositories;

import org.ectimel.dietgenerator.domain.generator.DietType;
import org.ectimel.dietgenerator.domain.model.MealType;
import org.ectimel.dietgenerator.infrastructure.persistance.mongo.documents.RecipeDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.UUID;

public interface SpringDataMongoRecipeRepository extends MongoRepository<RecipeDocument, UUID>{

    @Query("{ 'dietTypes' :  ?0 }")
    List<RecipeDocument> findAllByDietType(DietType dietType);

    @Query("{ 'dietTypes' : ?0, 'mealTypes' : ?1}")
    List<RecipeDocument> findAllByDietAndMealTypes(DietType dietType, MealType mealType);

}
